package id.nihongodictionary.app.presentation.screens.worddetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.core.datastore.AppPreferencesDataSource
import id.nihongodictionary.app.core.tts.JapaneseTtsManager
import id.nihongodictionary.app.core.tts.TtsStatus
import id.nihongodictionary.app.domain.usecase.GetWordDetailUseCase
import id.nihongodictionary.app.domain.usecase.ToggleBookmarkUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordDetailViewModel @Inject constructor(
    private val getWordDetailUseCase: GetWordDetailUseCase,
    private val toggleBookmarkUseCase: ToggleBookmarkUseCase,
    private val ttsManager: JapaneseTtsManager,
    private val preferencesDataSource: AppPreferencesDataSource
) : ViewModel() {

    private val _uiState = MutableStateFlow<WordDetailUiState>(WordDetailUiState.Loading)
    val uiState: StateFlow<WordDetailUiState> = _uiState.asStateFlow()

    private val _isBookmarked = MutableStateFlow(false)
    val isBookmarked: StateFlow<Boolean> = _isBookmarked.asStateFlow()

    private val _userFeedback = MutableSharedFlow<String>()
    val userFeedback: SharedFlow<String> = _userFeedback.asSharedFlow()

    private var bookmarkJob: Job? = null

    fun loadWordDetail(wordId: Long) {
        bookmarkJob?.cancel()
        bookmarkJob = viewModelScope.launch {
            toggleBookmarkUseCase.isBookmarked(wordId).collect {
                _isBookmarked.value = it
            }
        }

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

    fun toggleBookmark() {
        val currentState = _uiState.value
        if (currentState is WordDetailUiState.Success) {
            viewModelScope.launch {
                toggleBookmarkUseCase(currentState.data.word)
                    .onSuccess { isSaved ->
                        val message = if (isSaved) "Kata berhasil disimpan ke Tersimpan" else "Kata dihapus dari Tersimpan"
                        _userFeedback.emit(message)
                    }
                    .onFailure { error ->
                        _userFeedback.emit("Gagal menyimpan bookmark: ${error.localizedMessage}")
                    }
            }
        }
    }

    fun playAudio(text: String) {
        viewModelScope.launch {
            val status = ttsManager.status.value
            when (status) {
                is TtsStatus.LanguageMissingData -> {
                    _userFeedback.emit("Data suara Bahasa Jepang belum terpasang di perangkat ini. Silakan atur di Pengaturan > TTS.")
                    return@launch
                }
                is TtsStatus.LanguageNotSupported -> {
                    _userFeedback.emit("Mesin TTS pada perangkat ini tidak mendukung Bahasa Jepang.")
                    return@launch
                }
                is TtsStatus.Error -> {
                    _userFeedback.emit("Mesin TTS bermasalah: ${status.message}")
                    return@launch
                }
                else -> Unit
            }

            val settings = preferencesDataSource.settings.first()
            val played = ttsManager.speak(text, settings.speechRate, settings.pitch)
            if (!played) {
                _userFeedback.emit("Tidak dapat memutar suara. Pastikan data suara Jepang sudah aktif di sistem Android Anda.")
            }
        }
    }
}
