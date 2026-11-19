package id.nihongodictionary.app.core.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
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

    private val tag = "JapaneseTts"
    private var tts: TextToSpeech? = null
    private val _status = MutableStateFlow<TtsStatus>(TtsStatus.Initializing)
    val status: StateFlow<TtsStatus> = _status.asStateFlow()

    init {
        Log.d(tag, "Inisialisasi TextToSpeech engine...")
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        Log.d(tag, "onInit dipanggil dengan status: $status (SUCCESS=${TextToSpeech.SUCCESS})")
        if (status == TextToSpeech.SUCCESS) {
            val engine = tts
            if (engine == null) {
                _status.value = TtsStatus.Error("TTS Engine bernilai null saat onInit")
                return
            }

            val targetLocale = if (engine.isLanguageAvailable(Locale.JAPAN) >= TextToSpeech.LANG_AVAILABLE) {
                Locale.JAPAN
            } else {
                Locale.JAPANESE
            }

            val result = engine.setLanguage(targetLocale)
            Log.d(tag, "setLanguage($targetLocale) menghasilkan kode: $result")

            when {
                result >= TextToSpeech.LANG_AVAILABLE -> {
                    _status.value = TtsStatus.Ready
                    Log.d(tag, "TextToSpeech Bahasa Jepang SIAP digunakan!")
                }
                result == TextToSpeech.LANG_MISSING_DATA -> {
                    _status.value = TtsStatus.LanguageMissingData
                    Log.w(tag, "Data suara Bahasa Jepang belum terunduh (LANG_MISSING_DATA)")
                }
                result == TextToSpeech.LANG_NOT_SUPPORTED -> {
                    _status.value = TtsStatus.LanguageNotSupported
                    Log.w(tag, "Bahasa Jepang tidak didukung engine TTS (LANG_NOT_SUPPORTED)")
                }
                else -> {
                    _status.value = TtsStatus.Ready
                }
            }
        } else {
            _status.value = TtsStatus.Error("Gagal menginisialisasi TextToSpeech engine (kode status: $status)")
            Log.e(tag, "Gagal menginisialisasi TextToSpeech engine")
        }
    }

    fun speak(text: String, speechRate: Float = 1.0f, pitch: Float = 1.0f): Boolean {
        val currentStatus = _status.value
        Log.d(tag, "speak('$text') dipanggil. Status saat ini: $currentStatus")

        val engine = tts
        if (engine == null) {
            Log.e(tag, "Engine TTS null")
            return false
        }

        if (currentStatus !is TtsStatus.Ready) {
            val checkResult = engine.setLanguage(Locale.JAPANESE)
            Log.d(tag, "Percobaan ulang setLanguage(Locale.JAPANESE): $checkResult")
            if (checkResult >= TextToSpeech.LANG_AVAILABLE) {
                _status.value = TtsStatus.Ready
            } else {
                Log.w(tag, "TTS belum siap memutar suara. Status: $currentStatus")
                return false
            }
        }

        engine.setSpeechRate(speechRate.coerceIn(0.5f, 2.0f))
        engine.setPitch(pitch.coerceIn(0.5f, 2.0f))
        val res = engine.speak(text, TextToSpeech.QUEUE_FLUSH, null, "nihongo_tts_${System.currentTimeMillis()}")
        Log.d(tag, "engine.speak() dikirim dengan hasil: $res")
        return res == TextToSpeech.SUCCESS
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}
