package id.nihongodictionary.app.core.database.user.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey
    val wordId: Long,
    val spelling: String,
    val reading: String,
    val meaning: String,
    val savedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "search_history")
data class SearchHistoryEntity(
    @PrimaryKey
    val query: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "collections")
data class CollectionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(
    tableName = "collection_words",
    primaryKeys = ["collectionId", "wordId"]
)
data class CollectionWordCrossRef(
    val collectionId: Long,
    val wordId: Long
)
