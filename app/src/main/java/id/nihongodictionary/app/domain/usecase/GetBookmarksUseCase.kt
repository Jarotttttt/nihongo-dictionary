package id.nihongodictionary.app.domain.usecase

import id.nihongodictionary.app.domain.model.BookmarkItem
import id.nihongodictionary.app.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarksUseCase @Inject constructor(
    private val repository: UserDataRepository
) {
    operator fun invoke(): Flow<List<BookmarkItem>> {
        return repository.getAllBookmarks()
    }

    suspend fun remove(wordId: Long): Result<Unit> {
        return repository.removeBookmark(wordId)
    }
}
