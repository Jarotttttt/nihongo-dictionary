package id.nihongodictionary.app.presentation.screens.kanji

import id.nihongodictionary.app.domain.model.KanjiDetail

sealed interface KanjiUiState {
    data object Loading : KanjiUiState
    data class Success(val kanji: KanjiDetail) : KanjiUiState
    data class Error(val message: String) : KanjiUiState
}
