package id.nihongodictionary.app.domain.model

data class BookmarkItem(
    val wordId: Long,
    val spelling: String,
    val reading: String,
    val meaning: String,
    val savedAt: Long
)
