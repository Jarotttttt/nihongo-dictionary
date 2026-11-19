package id.nihongodictionary.app.presentation.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.core.datastore.AppPreferencesDataSource
import id.nihongodictionary.app.core.datastore.UserSettings
import id.nihongodictionary.app.core.tts.JapaneseTtsManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferencesDataSource: AppPreferencesDataSource,
    private val ttsManager: JapaneseTtsManager
) : ViewModel() {

    val settings: StateFlow<UserSettings> = preferencesDataSource.settings
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UserSettings()
        )

    val ttsStatus = ttsManager.status

    fun setSpeechRate(rate: Float) {
        viewModelScope.launch {
            preferencesDataSource.updateSpeechRate(rate)
        }
    }

    fun setPitch(pitch: Float) {
        viewModelScope.launch {
            preferencesDataSource.updatePitch(pitch)
        }
    }

    fun setThemeMode(mode: String) {
        viewModelScope.launch {
            preferencesDataSource.updateThemeMode(mode)
        }
    }

    fun testTtsVoice() {
        val current = settings.value
        ttsManager.speak("こんにちは、日本語の勉強を始めましょう。", current.speechRate, current.pitch)
    }
}
