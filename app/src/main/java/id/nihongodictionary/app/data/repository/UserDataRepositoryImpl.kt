package id.nihongodictionary.app.data.repository

import id.nihongodictionary.app.core.common.DataError
import id.nihongodictionary.app.core.common.DispatcherProvider
import id.nihongodictionary.app.core.database.user.dao.BookmarkDao
import id.nihongodictionary.app.core.database.user.dao.CollectionDao
import id.nihongodictionary.app.core.database.user.dao.SearchHistoryDao
import id.nihongodictionary.app.core.database.user.entity.BookmarkEntity
import id.nihongodictionary.app.core.database.user.entity.SearchHistoryEntity
import id.nihongodictionary.app.domain.model.BookmarkItem
import id.nihongodictionary.app.domain.model.Word
import id.nihongodictionary.app.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepositoryImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao,
    private val searchHistoryDao: SearchHistoryDao,
    private val collectionDao: CollectionDao,
    private val dispatchers: DispatcherProvider
) : UserDataRepository {

    override suspend fun toggleBookmark(word: Word): Result<Boolean> =
        withContext(dispatchers.io) {
            try {
                val exists = bookmarkDao.isBookmarked(word.id).first()
                if (exists) {
                    bookmarkDao.deleteBookmark(word.id)
                    Result.success(false)
                } else {
                    val meaning = word.senses.firstOrNull()?.glossId ?: ""
                    bookmarkDao.insertBookmark(
                        BookmarkEntity(
                            wordId = word.id,
                            spelling = word.primarySpelling,
                            reading = word.primaryReading,
                            meaning = meaning
                        )
                    )
                    Result.success(true)
                }
            } catch (e: Exception) {
                Result.failure(DataError.Local(e))
            }
        }

    override fun isBookmarked(wordId: Long): Flow<Boolean> {
        return bookmarkDao.isBookmarked(wordId)
    }

    override fun getAllBookmarks(): Flow<List<BookmarkItem>> {
        return bookmarkDao.getAllBookmarks().map { entities ->
            entities.map {
                BookmarkItem(
                    wordId = it.wordId,
                    spelling = it.spelling,
                    reading = it.reading,
                    meaning = it.meaning,
                    savedAt = it.savedAt
                )
            }
        }
    }

    override suspend fun removeBookmark(wordId: Long): Result<Unit> =
        withContext(dispatchers.io) {
            try {
                bookmarkDao.deleteBookmark(wordId)
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(DataError.Local(e))
            }
        }

    override suspend fun recordSearch(query: String) =
        withContext(dispatchers.io) {
            val q = query.trim()
            if (q.isNotEmpty()) {
                searchHistoryDao.insertHistory(SearchHistoryEntity(query = q))
            }
        }

    override fun getRecentSearchHistory(limit: Int): Flow<List<String>> {
        return searchHistoryDao.getRecentHistory(limit).map { list ->
            list.map { it.query }
        }
    }

    override suspend fun clearSearchHistory() =
        withContext(dispatchers.io) {
            searchHistoryDao.clearAll()
        }

    override suspend fun removeSearchItem(query: String) =
        withContext(dispatchers.io) {
            searchHistoryDao.deleteHistory(query)
        }
}
