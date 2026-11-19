package id.nihongodictionary.app.core.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "nihongo_settings")

data class UserSettings(
    val speechRate: Float = 1.0f,
    val pitch: Float = 1.0f,
    val themeMode: String = "SYSTEM", // SYSTEM, LIGHT, DARK
    val showFurigana: Boolean = true
)

@Singleton
class AppPreferencesDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object Keys {
        val SPEECH_RATE = floatPreferencesKey("tts_speech_rate")
        val PITCH = floatPreferencesKey("tts_pitch")
        val THEME_MODE = stringPreferencesKey("app_theme_mode")
        val SHOW_FURIGANA = booleanPreferencesKey("show_furigana")
    }

    val settings: Flow<UserSettings> = context.dataStore.data.map { prefs ->
        UserSettings(
            speechRate = prefs[Keys.SPEECH_RATE] ?: 1.0f,
            pitch = prefs[Keys.PITCH] ?: 1.0f,
            themeMode = prefs[Keys.THEME_MODE] ?: "SYSTEM",
            showFurigana = prefs[Keys.SHOW_FURIGANA] ?: true
        )
    }

    suspend fun updateSpeechRate(rate: Float) {
        context.dataStore.edit { it[Keys.SPEECH_RATE] = rate }
    }

    suspend fun updatePitch(pitch: Float) {
        context.dataStore.edit { it[Keys.PITCH] = pitch }
    }

    suspend fun updateThemeMode(mode: String) {
        context.dataStore.edit { it[Keys.THEME_MODE] = mode }
    }

    suspend fun updateShowFurigana(show: Boolean) {
        context.dataStore.edit { it[Keys.SHOW_FURIGANA] = show }
    }
}
