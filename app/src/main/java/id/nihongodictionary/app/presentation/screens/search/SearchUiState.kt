package id.nihongodictionary.app.presentation.screens.search

import id.nihongodictionary.app.domain.model.SearchFilter
import id.nihongodictionary.app.domain.model.Word

sealed interface SearchUiState {
    data object Idle : SearchUiState
    data object Loading : SearchUiState
    data class Success(val words: List<Word>) : SearchUiState
    data object Empty : SearchUiState
    data class Error(val message: String) : SearchUiState
}
