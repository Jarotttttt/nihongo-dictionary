package id.nihongodictionary.app.data.repository

import android.database.sqlite.SQLiteException
import id.nihongodictionary.app.core.common.DataError
import id.nihongodictionary.app.core.common.DispatcherProvider
import id.nihongodictionary.app.core.database.dictionary.DictionaryDatabaseHelper
import id.nihongodictionary.app.domain.model.KanjiDetail
import id.nihongodictionary.app.domain.model.KanjiReadingItem
import id.nihongodictionary.app.domain.model.KanjiStrokeItem
import id.nihongodictionary.app.domain.model.Word
import id.nihongodictionary.app.domain.model.WordSense
import id.nihongodictionary.app.domain.repository.KanjiRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KanjiRepositoryImpl @Inject constructor(
    private val dbHelper: DictionaryDatabaseHelper,
    private val dispatchers: DispatcherProvider
) : KanjiRepository {

    override suspend fun getKanjiDetail(kanjiId: Long): Result<KanjiDetail> =
        withContext(dispatchers.io) {
            try {
                val db = dbHelper.getReadableDatabase()

                var character = ""
                var strokeCount = 0
                var radicalNumber = 0
                var grade: Int? = null
                var jlptLevel: Int? = null
                var frequency: Int? = null
                var meaningId = ""

                db.rawQuery(
                    "SELECT character, stroke_count, radical_number, grade, jlpt_level, frequency, meaning_id FROM kanji WHERE id = ?",
                    arrayOf(kanjiId.toString())
                ).use { cursor ->
                    if (cursor.moveToFirst()) {
                        character = cursor.getString(0)
                        strokeCount = cursor.getInt(1)
                        radicalNumber = cursor.getInt(2)
                        grade = if (cursor.isNull(3)) null else cursor.getInt(3)
                        jlptLevel = if (cursor.isNull(4)) null else cursor.getInt(4)
                        frequency = if (cursor.isNull(5)) null else cursor.getInt(5)
                        meaningId = cursor.getString(6)
                    } else {
                        return@withContext Result.failure(DataError.NotFound("Kanji ID $kanjiId"))
                    }
                }

                // Readings
                val readings = mutableListOf<KanjiReadingItem>()
                db.rawQuery(
                    "SELECT reading_type, reading, reading_romaji FROM kanji_readings WHERE kanji_id = ?",
                    arrayOf(kanjiId.toString())
                ).use { cursor ->
                    while (cursor.moveToNext()) {
                        readings.add(
                            KanjiReadingItem(
                                type = cursor.getString(0),
                                reading = cursor.getString(1),
                                readingRomaji = cursor.getString(2)
                            )
                        )
                    }
                }

                // Strokes
                val strokes = mutableListOf<KanjiStrokeItem>()
                db.rawQuery(
                    "SELECT stroke_number, path_data, stroke_type FROM kanji_strokes WHERE kanji_id = ? ORDER BY stroke_number ASC",
                    arrayOf(kanjiId.toString())
                ).use { cursor ->
                    while (cursor.moveToNext()) {
                        strokes.add(
                            KanjiStrokeItem(
                                strokeNumber = cursor.getInt(0),
                                pathData = cursor.getString(1),
                                strokeType = cursor.getString(2)
                            )
                        )
                    }
                }

                // Related Words
                val relatedWords = mutableListOf<Word>()
                db.rawQuery(
                    """
                    SELECT w.id, w.jmdict_seq, w.primary_spelling, w.primary_reading, w.is_common, w.jlpt_level
                    FROM word_kanji_crossref c
                    JOIN words w ON c.word_id = w.id
                    WHERE c.kanji_id = ?
                    LIMIT 20
                    """,
                    arrayOf(kanjiId.toString())
                ).use { cursor ->
                    while (cursor.moveToNext()) {
                        val wordId = cursor.getLong(0)
                        val senses = mutableListOf<WordSense>()
                        db.rawQuery(
                            "SELECT id, sense_index, pos_tags, gloss_id, gloss_en FROM word_senses WHERE word_id = ? ORDER BY sense_index ASC",
                            arrayOf(wordId.toString())
                        ).use { sc ->
                            while (sc.moveToNext()) {
                                senses.add(
                                    WordSense(
                                        id = sc.getLong(0),
                                        senseIndex = sc.getInt(1),
                                        posTags = sc.getString(2) ?: "",
                                        glossId = sc.getString(3) ?: "",
                                        glossEn = sc.getString(4)
                                    )
                                )
                            }
                        }

                        relatedWords.add(
                            Word(
                                id = wordId,
                                jmdictSeq = cursor.getString(1),
                                primarySpelling = cursor.getString(2),
                                primaryReading = cursor.getString(3),
                                isCommon = cursor.getInt(4) == 1,
                                jlptLevel = if (cursor.isNull(5)) null else cursor.getInt(5),
                                senses = senses
                            )
                        )
                    }
                }

                Result.success(
                    KanjiDetail(
                        id = kanjiId,
                        character = character,
                        strokeCount = strokeCount,
                        radicalNumber = radicalNumber,
                        grade = grade,
                        jlptLevel = jlptLevel,
                        frequency = frequency,
                        meaningId = meaningId,
                        readings = readings,
                        strokes = strokes,
                        relatedWords = relatedWords
                    )
                )
            } catch (e: SQLiteException) {
                Result.failure(DataError.Database(e))
            } catch (e: Exception) {
                Result.failure(DataError.Database(e))
            }
        }
}
