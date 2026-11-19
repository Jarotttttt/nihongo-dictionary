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

enum class KanjiFilterCategory(val label: String, val grade: Int? = null, val jlptLevel: Int? = null) {
    GRADE_1("SD 1 (80)", grade = 1),
    GRADE_2("SD 2 (160)", grade = 2),
    GRADE_3("SD 3 (200)", grade = 3),
    GRADE_4("SD 4 (202)", grade = 4),
    GRADE_5("SD 5 (193)", grade = 5),
    GRADE_6("SD 6 (191)", grade = 6),
    JLPT_N5("JLPT N5 (103)", jlptLevel = 4),
    JLPT_N4("JLPT N4 (181)", jlptLevel = 3)
}

data class KanjiGridItem(
    val id: Long,
    val character: String,
    val strokeCount: Int,
    val meaningId: String,
    val onyomi: String?,
    val kunyomi: String?,
    val grade: Int?,
    val jlptLevel: Int?
)
