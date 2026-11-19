package id.nihongodictionary.app.domain.repository

import id.nihongodictionary.app.domain.model.KanjiDetail
import id.nihongodictionary.app.domain.model.KanjiFilterCategory
import id.nihongodictionary.app.domain.model.KanjiGridItem

interface KanjiRepository {
    suspend fun getKanjiDetail(kanjiId: Long): Result<KanjiDetail>
    suspend fun getKanjiByFilter(filter: KanjiFilterCategory): Result<List<KanjiGridItem>>
}
