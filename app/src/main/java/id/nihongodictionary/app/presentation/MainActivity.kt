package id.nihongodictionary.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dagger.hilt.android.AndroidEntryPoint
import id.nihongodictionary.app.presentation.designsystem.NihongoDictionaryTheme
import id.nihongodictionary.app.presentation.navigation.Screen
import id.nihongodictionary.app.presentation.screens.characters.CharactersScreen
import id.nihongodictionary.app.presentation.screens.characters.CharactersViewModel
import id.nihongodictionary.app.presentation.screens.characters.KanaDetailScreen
import id.nihongodictionary.app.presentation.screens.kanji.KanjiDetailScreen
import id.nihongodictionary.app.presentation.screens.kanji.KanjiDetailViewModel
import id.nihongodictionary.app.presentation.screens.saved.SavedVocabularyScreen
import id.nihongodictionary.app.presentation.screens.saved.SavedViewModel
import id.nihongodictionary.app.presentation.screens.search.SearchScreen
import id.nihongodictionary.app.presentation.screens.search.SearchViewModel
import id.nihongodictionary.app.presentation.screens.settings.AboutScreen
import id.nihongodictionary.app.presentation.screens.settings.SettingsScreen
import id.nihongodictionary.app.presentation.screens.settings.SettingsViewModel
import id.nihongodictionary.app.presentation.screens.worddetail.WordDetailScreen
import id.nihongodictionary.app.presentation.screens.worddetail.WordDetailViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NihongoDictionaryTheme {
                MainAppScaffold()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainAppScaffold() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .semantics { testTagsAsResourceId = true },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    modifier = Modifier.testTag("tab-kamus"),
                    selected = currentRoute?.contains("Search") == true,
                    onClick = {
                        navController.navigate(Screen.Search) {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = if (currentRoute?.contains("Search") == true) Icons.Filled.Search else Icons.Outlined.Search,
                            contentDescription = "Pencarian"
                        )
                    },
                    label = { Text("Kamus") }
                )
                NavigationBarItem(
                    modifier = Modifier.testTag("tab-characters"),
                    selected = currentRoute?.contains("Characters") == true,
                    onClick = {
                        navController.navigate(Screen.Characters) {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = if (currentRoute?.contains("Characters") == true) Icons.Filled.Translate else Icons.Outlined.Translate,
                            contentDescription = "Aksara"
                        )
                    },
                    label = { Text("Aksara") }
                )
                NavigationBarItem(
                    modifier = Modifier.testTag("tab-saved"),
                    selected = currentRoute?.contains("Saved") == true,
                    onClick = {
                        navController.navigate(Screen.Saved) {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = if (currentRoute?.contains("Saved") == true) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Tersimpan"
                        )
                    },
                    label = { Text("Tersimpan") }
                )
                NavigationBarItem(
                    modifier = Modifier.testTag("tab-settings"),
                    selected = currentRoute?.contains("Settings") == true,
                    onClick = {
                        navController.navigate(Screen.Settings) {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = if (currentRoute?.contains("Settings") == true) Icons.Filled.Settings else Icons.Outlined.Settings,
                            contentDescription = "Pengaturan"
                        )
                    },
                    label = { Text("Pengaturan") }
                )
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Screen.Search
            ) {
                composable<Screen.Search> {
                    val viewModel: SearchViewModel = hiltViewModel()
                    SearchScreen(
                        viewModel = viewModel,
                        onWordClick = { wordId ->
                            navController.navigate(Screen.WordDetail(wordId))
                        }
                    )
                }
                composable<Screen.Characters> {
                    val viewModel: CharactersViewModel = hiltViewModel()
                    CharactersScreen(
                        viewModel = viewModel,
                        onKanjiClick = { kanjiId ->
                            navController.navigate(Screen.KanjiDetail(kanjiId))
                        },
                        onKanaClick = { character ->
                            navController.navigate(Screen.KanaDetail(character))
                        }
                    )
                }
                composable<Screen.KanaDetail> { backStackEntry ->
                    val route: Screen.KanaDetail = backStackEntry.toRoute()
                    val viewModel: CharactersViewModel = hiltViewModel()
                    KanaDetailScreen(
                        character = route.character,
                        viewModel = viewModel,
                        onBackClick = { navController.popBackStack() }
                    )
                }
                composable<Screen.WordDetail> { backStackEntry ->
                    val route: Screen.WordDetail = backStackEntry.toRoute()
                    val viewModel: WordDetailViewModel = hiltViewModel()
                    WordDetailScreen(
                        wordId = route.wordId,
                        viewModel = viewModel,
                        onBackClick = { navController.popBackStack() },
                        onKanjiClick = { kanjiId ->
                            navController.navigate(Screen.KanjiDetail(kanjiId))
                        },
                        onPlayAudio = viewModel::playAudio
                    )
                }
                composable<Screen.KanjiDetail> { backStackEntry ->
                    val route: Screen.KanjiDetail = backStackEntry.toRoute()
                    val viewModel: KanjiDetailViewModel = hiltViewModel()
                    KanjiDetailScreen(
                        kanjiId = route.kanjiId,
                        viewModel = viewModel,
                        onBackClick = { navController.popBackStack() },
                        onWordClick = { wordId ->
                            navController.navigate(Screen.WordDetail(wordId))
                        }
                    )
                }
                composable<Screen.Saved> {
                    val viewModel: SavedViewModel = hiltViewModel()
                    SavedVocabularyScreen(
                        viewModel = viewModel,
                        onWordClick = { wordId ->
                            navController.navigate(Screen.WordDetail(wordId))
                        }
                    )
                }
                composable<Screen.Settings> {
                    val viewModel: SettingsViewModel = hiltViewModel()
                    SettingsScreen(
                        viewModel = viewModel,
                        onAboutClick = {
                            navController.navigate(Screen.About)
                        }
                    )
                }
                composable<Screen.About> {
                    AboutScreen(
                        onBackClick = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}
