package id.nihongodictionary.app.data.repository

import android.database.Cursor
import android.database.sqlite.SQLiteException
import id.nihongodictionary.app.core.common.DataError
import id.nihongodictionary.app.core.common.DispatcherProvider
import id.nihongodictionary.app.core.common.JapaneseSearchNormalizer
import id.nihongodictionary.app.core.common.ScriptType
import id.nihongodictionary.app.core.database.dictionary.DictionaryDatabaseHelper
import id.nihongodictionary.app.domain.model.ExampleSentence
import id.nihongodictionary.app.domain.model.JlptFilter
import id.nihongodictionary.app.domain.model.KanjiSimple
import id.nihongodictionary.app.domain.model.SearchFilter
import id.nihongodictionary.app.domain.model.Word
import id.nihongodictionary.app.domain.model.WordDetailData
import id.nihongodictionary.app.domain.model.WordSense
import id.nihongodictionary.app.domain.repository.DictionaryRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DictionaryRepositoryImpl @Inject constructor(
    private val dbHelper: DictionaryDatabaseHelper,
    private val dispatchers: DispatcherProvider
) : DictionaryRepository {

    override suspend fun searchWords(query: String, filter: SearchFilter): Result<List<Word>> =
        withContext(dispatchers.io) {
            val trimmed = query.trim()
            if (trimmed.isEmpty()) {
                return@withContext Result.success(emptyList())
            }

            try {
                val db = dbHelper.getReadableDatabase()
                val normalized = JapaneseSearchNormalizer.normalize(trimmed)
                val script = JapaneseSearchNormalizer.detectScriptType(trimmed)

                val hiraganaQuery = when (script) {
                    ScriptType.KANA -> JapaneseSearchNormalizer.toHiragana(trimmed)
                    ScriptType.ROMAJI -> JapaneseSearchNormalizer.romajiToHiragana(normalized)
                    else -> ""
                }

                val words = mutableListOf<Word>()
                val seenWordIds = mutableSetOf<Long>()

                // 1. Japanese Spelling / Reading Search
                val sql = StringBuilder(
                    """
                    SELECT w.id, w.jmdict_seq, w.primary_spelling, w.primary_reading, w.is_common, w.jlpt_level
                    FROM words w
                    LEFT JOIN word_readings r ON w.id = r.word_id
                    WHERE (
                        w.primary_spelling LIKE ? || '%'
                        OR r.reading_hiragana LIKE ? || '%'
                        OR r.reading_romaji LIKE ? || '%'
                    )
                    """
                )

                if (filter.onlyCommon) {
                    sql.append(" AND w.is_common = 1")
                }
                if (filter.jlptFilter != JlptFilter.ALL) {
                    val level = when (filter.jlptFilter) {
                        JlptFilter.N5 -> 5
                        JlptFilter.N4 -> 4
                        JlptFilter.N3 -> 3
                        JlptFilter.N2 -> 2
                        JlptFilter.N1 -> 1
                        else -> 0
                    }
                    sql.append(" AND w.jlpt_level = $level")
                }

                sql.append(" ORDER BY (w.primary_spelling = ?) DESC, w.is_common DESC, length(w.primary_spelling) ASC LIMIT 50")

                val queryParam = if (hiraganaQuery.isNotEmpty()) hiraganaQuery else trimmed
                db.rawQuery(
                    sql.toString(),
                    arrayOf(trimmed, queryParam, normalized, trimmed)
                ).use { cursor ->
                    while (cursor.moveToNext()) {
                        val wordId = cursor.getLong(0)
                        if (seenWordIds.add(wordId)) {
                            words.add(extractWordFromCursor(cursor, db))
                        }
                    }
                }

                // 2. Indonesian Reverse Search via Indexed LIKE (100% Android 10+ Compatible)
                if (words.size < 20 && (script == ScriptType.ROMAJI || script == ScriptType.LATIN_INDONESIAN)) {
                    val reverseSql = """
                        SELECT DISTINCT w.id, w.jmdict_seq, w.primary_spelling, w.primary_reading, w.is_common, w.jlpt_level
                        FROM word_senses s
                        JOIN words w ON s.word_id = w.id
                        WHERE s.gloss_id LIKE '%' || ? || '%'
                        ORDER BY w.is_common DESC, length(w.primary_spelling) ASC
                        LIMIT 30
                    """
                    db.rawQuery(reverseSql, arrayOf(normalized)).use { cursor ->
                        while (cursor.moveToNext()) {
                            val wordId = cursor.getLong(0)
                            if (seenWordIds.add(wordId)) {
                                words.add(extractWordFromCursor(cursor, db))
                            }
                        }
                    }
                }

                Result.success(words)
            } catch (e: SQLiteException) {
                Result.failure(DataError.Database(e))
            } catch (e: Exception) {
                Result.failure(DataError.Database(e))
            }
        }

    override suspend fun getWordDetail(wordId: Long): Result<WordDetailData> =
        withContext(dispatchers.io) {
            try {
                val db = dbHelper.getReadableDatabase()

                // Fetch Word
                var word: Word? = null
                db.rawQuery(
                    "SELECT id, jmdict_seq, primary_spelling, primary_reading, is_common, jlpt_level FROM words WHERE id = ?",
                    arrayOf(wordId.toString())
                ).use { cursor ->
                    if (cursor.moveToFirst()) {
                        word = extractWordFromCursor(cursor, db)
                    }
                }

                if (word == null) {
                    return@withContext Result.failure(DataError.NotFound("Kata ID $wordId"))
                }

                // Fetch Related Kanji
                val kanjiList = mutableListOf<KanjiSimple>()
                db.rawQuery(
                    """
                    SELECT k.id, k.character, k.stroke_count, k.meaning_id
                    FROM word_kanji_crossref c
                    JOIN kanji k ON c.kanji_id = k.id
                    WHERE c.word_id = ?
                    ORDER BY k.stroke_count ASC
                    """,
                    arrayOf(wordId.toString())
                ).use { cursor ->
                    while (cursor.moveToNext()) {
                        kanjiList.add(
                            KanjiSimple(
                                id = cursor.getLong(0),
                                character = cursor.getString(1),
                                strokeCount = cursor.getInt(2),
                                meaningId = cursor.getString(3)
                            )
                        )
                    }
                }

                // Fetch Example Sentences
                val sentenceList = mutableListOf<ExampleSentence>()
                db.rawQuery(
                    """
                    SELECT s.id, s.japanese_text, s.indonesian_text
                    FROM word_examples_crossref c
                    JOIN sentence_examples s ON c.sentence_id = s.id
                    WHERE c.word_id = ?
                    LIMIT 10
                    """,
                    arrayOf(wordId.toString())
                ).use { cursor ->
                    while (cursor.moveToNext()) {
                        sentenceList.add(
                            ExampleSentence(
                                id = cursor.getLong(0),
                                japaneseText = cursor.getString(1),
                                indonesianText = cursor.getString(2)
                            )
                        )
                    }
                }

                Result.success(
                    WordDetailData(
                        word = word!!,
                        kanjiList = kanjiList,
                        exampleSentences = sentenceList
                    )
                )
            } catch (e: SQLiteException) {
                Result.failure(DataError.Database(e))
            } catch (e: Exception) {
                Result.failure(DataError.Database(e))
            }
        }

    private fun extractWordFromCursor(cursor: Cursor, db: android.database.sqlite.SQLiteDatabase): Word {
        val wordId = cursor.getLong(0)
        val jmdictSeq = cursor.getString(1)
        val spelling = cursor.getString(2)
        val reading = cursor.getString(3)
        val isCommon = cursor.getInt(4) == 1
        val jlptLevel = if (cursor.isNull(5)) null else cursor.getInt(5)

        val senses = mutableListOf<WordSense>()
        db.rawQuery(
            "SELECT id, sense_index, pos_tags, gloss_id, gloss_en FROM word_senses WHERE word_id = ? ORDER BY sense_index ASC",
            arrayOf(wordId.toString())
        ).use { senseCursor ->
            while (senseCursor.moveToNext()) {
                senses.add(
                    WordSense(
                        id = senseCursor.getLong(0),
                        senseIndex = senseCursor.getInt(1),
                        posTags = senseCursor.getString(2) ?: "",
                        glossId = senseCursor.getString(3) ?: "",
                        glossEn = senseCursor.getString(4)
                    )
                )
            }
        }

        return Word(
            id = wordId,
            jmdictSeq = jmdictSeq,
            primarySpelling = spelling,
            primaryReading = reading,
            isCommon = isCommon,
            jlptLevel = jlptLevel,
            senses = senses
        )
    }
}
