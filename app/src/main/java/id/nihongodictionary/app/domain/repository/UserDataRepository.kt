package id.nihongodictionary.app.domain.repository

import id.nihongodictionary.app.domain.model.BookmarkItem
import id.nihongodictionary.app.domain.model.Word
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    suspend fun toggleBookmark(word: Word): Result<Boolean>
    fun isBookmarked(wordId: Long): Flow<Boolean>
    fun getAllBookmarks(): Flow<List<BookmarkItem>>
    suspend fun removeBookmark(wordId: Long): Result<Unit>

    suspend fun recordSearch(query: String)
    fun getRecentSearchHistory(limit: Int = 20): Flow<List<String>>
    suspend fun clearSearchHistory()
    suspend fun removeSearchItem(query: String)
}
