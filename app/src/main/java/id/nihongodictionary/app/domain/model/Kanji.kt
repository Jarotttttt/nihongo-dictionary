package id.nihongodictionary.app.domain.model

data class KanjiReadingItem(
    val type: String, // 'onyomi', 'kunyomi'
    val reading: String,
    val readingRomaji: String
)

data class KanjiStrokeItem(
    val strokeNumber: Int,
    val pathData: String,
    val strokeType: String?
)

data class KanjiDetail(
    val id: Long,
    val character: String,
    val strokeCount: Int,
    val radicalNumber: Int,
    val grade: Int?,
    val jlptLevel: Int?,
    val frequency: Int?,
    val meaningId: String,
    val readings: List<KanjiReadingItem> = emptyList(),
    val strokes: List<KanjiStrokeItem> = emptyList(),
    val relatedWords: List<Word> = emptyList()
)
