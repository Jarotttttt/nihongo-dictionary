package id.nihongodictionary.app.domain.model

data class Word(
    val id: Long,
    val jmdictSeq: String?,
    val primarySpelling: String,
    val primaryReading: String,
    val isCommon: Boolean,
    val jlptLevel: Int?,
    val senses: List<WordSense> = emptyList()
)

data class WordSense(
    val id: Long,
    val senseIndex: Int,
    val posTags: String,
    val glossId: String,
    val glossEn: String?
)

data class ExampleSentence(
    val id: Long,
    val japaneseText: String,
    val indonesianText: String
)

data class WordDetailData(
    val word: Word,
    val kanjiList: List<KanjiSimple> = emptyList(),
    val exampleSentences: List<ExampleSentence> = emptyList()
)

data class KanjiSimple(
    val id: Long,
    val character: String,
    val strokeCount: Int,
    val meaningId: String
)

enum class JlptFilter {
    ALL, N5, N4, N3, N2, N1
}

data class SearchFilter(
    val jlptFilter: JlptFilter = JlptFilter.ALL,
    val onlyCommon: Boolean = false
)
