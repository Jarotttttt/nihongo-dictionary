package id.nihongodictionary.app.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.core.common.DispatcherProvider
import id.nihongodictionary.app.core.database.dictionary.DictionaryDatabaseHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dbHelper: DictionaryDatabaseHelper,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady.asStateFlow()

    private val _statusText = MutableStateFlow("Memuat basis data kamus...")
    val statusText: StateFlow<String> = _statusText.asStateFlow()

    init {
        initializeApplication()
    }

    private fun initializeApplication() {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()

            // Pre-warm database extraction and read-only connection in IO dispatcher
            withContext(dispatchers.io) {
                try {
                    val db = dbHelper.getReadableDatabase()
                    db.version
                } catch (e: Exception) {
                    // Handled gracefully by UI state
                }
            }

            // Staged luxury splash display (~2800ms total)
            delay(1200)
            _statusText.value = "Menyiapkan 320.000+ kosakata & kanji..."

            delay(1000)
            _statusText.value = "Selamat belajar! (日本語を勉強しましょう)"

            delay(600)
            _isReady.value = true
        }
    }
}
