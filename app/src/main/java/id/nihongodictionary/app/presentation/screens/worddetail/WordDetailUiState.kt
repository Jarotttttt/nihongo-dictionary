package id.nihongodictionary.app.presentation.screens.worddetail

import id.nihongodictionary.app.domain.model.WordDetailData

sealed interface WordDetailUiState {
    data object Loading : WordDetailUiState
    data class Success(val data: WordDetailData) : WordDetailUiState
    data class Error(val message: String) : WordDetailUiState
}
