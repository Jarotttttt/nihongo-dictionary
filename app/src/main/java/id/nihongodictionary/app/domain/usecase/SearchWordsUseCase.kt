package id.nihongodictionary.app.domain.usecase

import id.nihongodictionary.app.domain.model.SearchFilter
import id.nihongodictionary.app.domain.model.Word
import id.nihongodictionary.app.domain.repository.DictionaryRepository
import javax.inject.Inject

class SearchWordsUseCase @Inject constructor(
    private val repository: DictionaryRepository
) {
    suspend operator fun invoke(query: String, filter: SearchFilter = SearchFilter()): Result<List<Word>> {
        return repository.searchWords(query, filter)
    }
}
