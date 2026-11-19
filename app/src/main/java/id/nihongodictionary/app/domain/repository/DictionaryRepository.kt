package id.nihongodictionary.app.domain.repository

import id.nihongodictionary.app.domain.model.SearchFilter
import id.nihongodictionary.app.domain.model.Word
import id.nihongodictionary.app.domain.model.WordDetailData

interface DictionaryRepository {
    suspend fun searchWords(query: String, filter: SearchFilter = SearchFilter()): Result<List<Word>>
    suspend fun getWordDetail(wordId: Long): Result<WordDetailData>
}
