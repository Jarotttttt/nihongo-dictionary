package id.nihongodictionary.app.domain.usecase

import id.nihongodictionary.app.domain.model.WordDetailData
import id.nihongodictionary.app.domain.repository.DictionaryRepository
import javax.inject.Inject

class GetWordDetailUseCase @Inject constructor(
    private val repository: DictionaryRepository
) {
    suspend operator fun invoke(wordId: Long): Result<WordDetailData> {
        return repository.getWordDetail(wordId)
    }
}
