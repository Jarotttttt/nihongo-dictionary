package id.nihongodictionary.app.presentation.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.core.tts.JapaneseTtsManager
import id.nihongodictionary.app.domain.model.KanaCategory
import id.nihongodictionary.app.domain.model.KanjiFilterCategory
import id.nihongodictionary.app.domain.model.KanjiGridItem
import id.nihongodictionary.app.domain.repository.KanjiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class MainCharacterTab {
    HIRAGANA,
    KATAKANA,
    KANJI,
    RADICALS
}

sealed interface KanjiListUiState {
    data object Loading : KanjiListUiState
    data class Success(val kanjiList: List<KanjiGridItem>) : KanjiListUiState
    data class Error(val message: String) : KanjiListUiState
}

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val kanjiRepository: KanjiRepository,
    private val ttsManager: JapaneseTtsManager
) : ViewModel() {

    private val _selectedTab = MutableStateFlow(MainCharacterTab.HIRAGANA)
    val selectedTab: StateFlow<MainCharacterTab> = _selectedTab.asStateFlow()

    private val _selectedKanaCategory = MutableStateFlow(KanaCategory.GOJUON)
    val selectedKanaCategory: StateFlow<KanaCategory> = _selectedKanaCategory.asStateFlow()

    private val _selectedKanjiFilter = MutableStateFlow(KanjiFilterCategory.GRADE_1)
    val selectedKanjiFilter: StateFlow<KanjiFilterCategory> = _selectedKanjiFilter.asStateFlow()

    private val _kanjiState = MutableStateFlow<KanjiListUiState>(KanjiListUiState.Loading)
    val kanjiState: StateFlow<KanjiListUiState> = _kanjiState.asStateFlow()

    private val _audioFeedback = MutableSharedFlow<String>()
    val audioFeedback: SharedFlow<String> = _audioFeedback.asSharedFlow()

    private val kanjiCache = mutableMapOf<KanjiFilterCategory, List<KanjiGridItem>>()

    fun selectTab(tab: MainCharacterTab) {
        _selectedTab.value = tab
        if (tab == MainCharacterTab.KANJI && _kanjiState.value !is KanjiListUiState.Success) {
            loadKanjiList(_selectedKanjiFilter.value)
        }
    }

    fun selectKanaCategory(category: KanaCategory) {
        _selectedKanaCategory.value = category
    }

    fun selectKanjiFilter(filter: KanjiFilterCategory) {
        _selectedKanjiFilter.value = filter
        loadKanjiList(filter)
    }

    fun loadKanjiList(filter: KanjiFilterCategory) {
        kanjiCache[filter]?.let { cached ->
            _kanjiState.value = KanjiListUiState.Success(cached)
            return
        }

        viewModelScope.launch {
            _kanjiState.value = KanjiListUiState.Loading
            kanjiRepository.getKanjiByFilter(filter).fold(
                onSuccess = { list ->
                    kanjiCache[filter] = list
                    _kanjiState.value = KanjiListUiState.Success(list)
                },
                onFailure = { error ->
                    _kanjiState.value = KanjiListUiState.Error(
                        error.message ?: "Gagal memuat daftar Kanji."
                    )
                }
            )
        }
    }

    fun playAudio(text: String) {
        if (text.isBlank()) return
        viewModelScope.launch(Dispatchers.Default) {
            val success = ttsManager.speak(text)
            if (!success) {
                _audioFeedback.emit("TTS belum siap atau bahasa Jepang belum tersedia")
            }
        }
    }
}
