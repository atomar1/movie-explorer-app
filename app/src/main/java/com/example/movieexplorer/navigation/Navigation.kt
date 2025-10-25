package com.example.movieexplorer.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{movieId}") {
        fun createRoute(movieId: Int) = "details/$movieId"
    }
    object Watchlist : Screen("watchlist")
}