package id.nihongodictionary.app.presentation.screens.worddetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.domain.usecase.GetWordDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordDetailViewModel @Inject constructor(
    private val getWordDetailUseCase: GetWordDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<WordDetailUiState>(WordDetailUiState.Loading)
    val uiState: StateFlow<WordDetailUiState> = _uiState.asStateFlow()

    fun loadWordDetail(wordId: Long) {
        viewModelScope.launch {
            _uiState.value = WordDetailUiState.Loading
            getWordDetailUseCase(wordId)
                .onSuccess { data ->
                    _uiState.value = WordDetailUiState.Success(data)
                }
                .onFailure { error ->
                    _uiState.value = WordDetailUiState.Error(
                        error.localizedMessage ?: "Gagal memuat detail kata"
                    )
                }
        }
    }
}
