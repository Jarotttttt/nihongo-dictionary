package id.nihongodictionary.app.core.database.user.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.nihongodictionary.app.core.database.user.entity.BookmarkEntity
import id.nihongodictionary.app.core.database.user.entity.CollectionEntity
import id.nihongodictionary.app.core.database.user.entity.SearchHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE wordId = :wordId")
    suspend fun deleteBookmark(wordId: Long)

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE wordId = :wordId)")
    fun isBookmarked(wordId: Long): Flow<Boolean>

    @Query("SELECT * FROM bookmarks ORDER BY savedAt DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>
}

@Dao
interface SearchHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(item: SearchHistoryEntity)

    @Query("DELETE FROM search_history WHERE query = :query")
    suspend fun deleteHistory(query: String)

    @Query("DELETE FROM search_history")
    suspend fun clearAll()

    @Query("SELECT * FROM search_history ORDER BY timestamp DESC LIMIT :limit")
    fun getRecentHistory(limit: Int = 50): Flow<List<SearchHistoryEntity>>
}

@Dao
interface CollectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collection: CollectionEntity): Long

    @Query("DELETE FROM collections WHERE id = :id")
    suspend fun deleteCollection(id: Long)

    @Query("SELECT * FROM collections ORDER BY createdAt DESC")
    fun getAllCollections(): Flow<List<CollectionEntity>>
}
