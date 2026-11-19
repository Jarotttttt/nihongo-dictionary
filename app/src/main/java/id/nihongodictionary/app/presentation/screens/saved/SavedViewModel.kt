package id.nihongodictionary.app.presentation.screens.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.domain.usecase.GetBookmarksUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val getBookmarksUseCase: GetBookmarksUseCase
) : ViewModel() {

    val uiState: StateFlow<SavedUiState> = getBookmarksUseCase()
        .map { bookmarks ->
            if (bookmarks.isEmpty()) SavedUiState.Empty else SavedUiState.Success(bookmarks)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = SavedUiState.Loading
        )

    fun removeBookmark(wordId: Long) {
        viewModelScope.launch {
            getBookmarksUseCase.remove(wordId)
        }
    }
}
