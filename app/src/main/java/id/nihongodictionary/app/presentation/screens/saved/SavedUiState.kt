package id.nihongodictionary.app.presentation.screens.saved

import id.nihongodictionary.app.domain.model.BookmarkItem

sealed interface SavedUiState {
    data object Loading : SavedUiState
    data class Success(val bookmarks: List<BookmarkItem>) : SavedUiState
    data object Empty : SavedUiState
}
