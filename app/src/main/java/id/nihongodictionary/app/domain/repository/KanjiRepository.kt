package id.nihongodictionary.app.domain.repository

import id.nihongodictionary.app.domain.model.KanjiDetail

interface KanjiRepository {
    suspend fun getKanjiDetail(kanjiId: Long): Result<KanjiDetail>
}
