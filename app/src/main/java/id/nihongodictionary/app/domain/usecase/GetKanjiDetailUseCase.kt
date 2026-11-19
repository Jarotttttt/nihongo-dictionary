package id.nihongodictionary.app.domain.usecase

import id.nihongodictionary.app.domain.model.KanjiDetail
import id.nihongodictionary.app.domain.repository.KanjiRepository
import javax.inject.Inject

class GetKanjiDetailUseCase @Inject constructor(
    private val repository: KanjiRepository
) {
    suspend operator fun invoke(kanjiId: Long): Result<KanjiDetail> {
        return repository.getKanjiDetail(kanjiId)
    }
}
