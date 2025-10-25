package com.example.movieexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieexplorer.navigation.Screen
import com.example.movieexplorer.ui.screens.DetailsScreen
import com.example.movieexplorer.ui.screens.HomeScreen
import com.example.movieexplorer.ui.screens.WatchlistScreen
import com.example.movieexplorer.ui.theme.MovieExplorerTheme
import com.example.movieexplorer.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieExplorerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieExplorerApp()
                }
            }
        }
    }
}

@Composable
fun MovieExplorerApp() {
    val navController = rememberNavController()
    val viewModel: MovieViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                onMovieClick = { movieId ->
                    navController.navigate(Screen.Details.createRoute(movieId))
                },
                onWatchlistClick = {
                    navController.navigate(Screen.Watchlist.route)
                }
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("movieId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: return@composable
            DetailsScreen(
                movieId = movieId,
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() }
            )
        }

        composable(Screen.Watchlist.route) {
            WatchlistScreen(
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() },
                onMovieClick = { movieId ->
                    navController.navigate(Screen.Details.createRoute(movieId))
                }
            )
        }
    }
}