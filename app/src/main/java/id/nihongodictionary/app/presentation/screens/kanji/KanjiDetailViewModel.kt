package id.nihongodictionary.app.presentation.screens.kanji

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.domain.usecase.GetKanjiDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KanjiDetailViewModel @Inject constructor(
    private val getKanjiDetailUseCase: GetKanjiDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<KanjiUiState>(KanjiUiState.Loading)
    val uiState: StateFlow<KanjiUiState> = _uiState.asStateFlow()

    fun loadKanji(kanjiId: Long) {
        viewModelScope.launch {
            _uiState.value = KanjiUiState.Loading
            getKanjiDetailUseCase(kanjiId)
                .onSuccess { data ->
                    _uiState.value = KanjiUiState.Success(data)
                }
                .onFailure { error ->
                    _uiState.value = KanjiUiState.Error(
                        error.localizedMessage ?: "Gagal memuat detail kanji"
                    )
                }
        }
    }
}
