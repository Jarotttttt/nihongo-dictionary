package id.nihongodictionary.app.domain.usecase

import id.nihongodictionary.app.domain.model.Word
import id.nihongodictionary.app.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToggleBookmarkUseCase @Inject constructor(
    private val repository: UserDataRepository
) {
    suspend operator fun invoke(word: Word): Result<Boolean> {
        return repository.toggleBookmark(word)
    }

    fun isBookmarked(wordId: Long): Flow<Boolean> {
        return repository.isBookmarked(wordId)
    }
}
