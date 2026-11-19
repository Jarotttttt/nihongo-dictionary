package id.nihongodictionary.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dagger.hilt.android.AndroidEntryPoint
import id.nihongodictionary.app.presentation.designsystem.NihongoDictionaryTheme
import id.nihongodictionary.app.presentation.navigation.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NihongoDictionaryTheme {
                MainAppScaffold()
            }
        }
    }
}

@Composable
fun MainAppScaffold() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
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
                    // Placeholder for SearchScreen
                    Text("Layar Pencarian Kamus")
                }
                composable<Screen.WordDetail> { backStackEntry ->
                    val route: Screen.WordDetail = backStackEntry.toRoute()
                    Text("Detail Kosakata ID: ${route.wordId}")
                }
                composable<Screen.KanjiDetail> { backStackEntry ->
                    val route: Screen.KanjiDetail = backStackEntry.toRoute()
                    Text("Detail Kanji ID: ${route.kanjiId}")
                }
                composable<Screen.Saved> {
                    Text("Kosakata Tersimpan")
                }
                composable<Screen.Settings> {
                    Text("Pengaturan Aplikasi")
                }
                composable<Screen.About> {
                    Text("Tentang & Atribusi Lisensi")
                }
            }
        }
    }
}
