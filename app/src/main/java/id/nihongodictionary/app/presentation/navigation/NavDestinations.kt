package id.nihongodictionary.app.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Search : Screen

    @Serializable
    data object Characters : Screen

    @Serializable
    data class WordDetail(val wordId: Long) : Screen

    @Serializable
    data class KanjiDetail(val kanjiId: Long) : Screen

    @Serializable
    data object Saved : Screen

    @Serializable
    data object Settings : Screen

    @Serializable
    data object About : Screen
}
