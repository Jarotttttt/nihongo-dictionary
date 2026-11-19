package id.nihongodictionary.app.core.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

sealed interface TtsStatus {
    data object Initializing : TtsStatus
    data object Ready : TtsStatus
    data object LanguageMissingData : TtsStatus
    data object LanguageNotSupported : TtsStatus
    data class Error(val message: String) : TtsStatus
}

@Singleton
class JapaneseTtsManager @Inject constructor(
    @ApplicationContext private val context: Context
) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private val _status = MutableStateFlow<TtsStatus>(TtsStatus.Initializing)
    val status: StateFlow<TtsStatus> = _status.asStateFlow()

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.JAPANESE) ?: TextToSpeech.LANG_NOT_SUPPORTED
            when (result) {
                TextToSpeech.LANG_MISSING_DATA -> {
                    _status.value = TtsStatus.LanguageMissingData
                }
                TextToSpeech.LANG_NOT_SUPPORTED -> {
                    _status.value = TtsStatus.LanguageNotSupported
                }
                else -> {
                    _status.value = TtsStatus.Ready
                }
            }
        } else {
            _status.value = TtsStatus.Error("Gagal menginisialisasi TextToSpeech engine")
        }
    }

    fun speak(text: String, speechRate: Float = 1.0f, pitch: Float = 1.0f) {
        if (_status.value !is TtsStatus.Ready) return

        tts?.let { engine ->
            engine.setSpeechRate(speechRate.coerceIn(0.5f, 2.0f))
            engine.setPitch(pitch.coerceIn(0.5f, 2.0f))
            engine.speak(text, TextToSpeech.QUEUE_FLUSH, null, "nihongo_tts_${System.currentTimeMillis()}")
        }
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}
