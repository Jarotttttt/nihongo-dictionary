package id.nihongodictionary.app.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.nihongodictionary.app.domain.model.JlptFilter
import id.nihongodictionary.app.domain.model.SearchFilter
import id.nihongodictionary.app.domain.usecase.SearchWordsUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchWordsUseCase: SearchWordsUseCase
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    private val _filter = MutableStateFlow(SearchFilter())
    val filter: StateFlow<SearchFilter> = _filter.asStateFlow()

    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Idle)
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    init {
        combine(
            _query.debounce(300).distinctUntilChanged(),
            _filter
        ) { q, f ->
            Pair(q, f)
        }.onEach { (q, f) ->
            if (q.isBlank()) {
                _uiState.value = SearchUiState.Idle
            } else {
                performSearch(q, f)
            }
        }.launchIn(viewModelScope)
    }

    fun onQueryChange(newQuery: String) {
        _query.value = newQuery
    }

    fun onJlptFilterChange(jlpt: JlptFilter) {
        _filter.value = _filter.value.copy(jlptFilter = jlpt)
    }

    fun toggleCommonOnly() {
        _filter.value = _filter.value.copy(onlyCommon = !_filter.value.onlyCommon)
    }

    fun clearQuery() {
        _query.value = ""
        _uiState.value = SearchUiState.Idle
    }

    private fun performSearch(q: String, f: SearchFilter) {
        viewModelScope.launch {
            _uiState.value = SearchUiState.Loading
            searchWordsUseCase(q, f)
                .onSuccess { results ->
                    _uiState.value = if (results.isEmpty()) {
                        SearchUiState.Empty
                    } else {
                        SearchUiState.Success(results)
                    }
                }
                .onFailure { error ->
                    _uiState.value = SearchUiState.Error(error.localizedMessage ?: "Gagal memuat hasil pencarian")
                }
        }
    }
}
