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

    private val _statusText = MutableStateFlow("Menyiapkan aplikasi...")
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
                    _statusText.value = "Memuat basis data kamus..."
                    val db = dbHelper.getReadableDatabase()
                    // Warm up SQLite by querying version
                    db.version
                } catch (e: Exception) {
                    _statusText.value = "Menyiapkan sistem..."
                }
            }

            // Ensure splash animation plays smoothly for at least 1200ms
            val elapsedTime = System.currentTimeMillis() - startTime
            val remainingDelay = (1200 - elapsedTime).coerceAtLeast(400)
            delay(remainingDelay)

            _isReady.value = true
        }
    }
}
