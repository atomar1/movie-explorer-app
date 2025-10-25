package com.example.movieexplorer.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.movieexplorer.model.Movie

class MovieViewModel : ViewModel() {

    // Hardcoded movie data
    private val _movies = mutableStateListOf(
        Movie(
            id = 1,
            title = "The Shawshank Redemption",
            description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            rating = 9.3,
            releaseYear = 1994,
            genre = "Drama",
            posterUrl = "🎬",
            director = "Frank Darabont",
            duration = "2h 22m"
        ),
        Movie(
            id = 2,
            title = "The Dark Knight",
            description = "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests.",
            rating = 9.0,
            releaseYear = 2008,
            genre = "Action",
            posterUrl = "🦇",
            director = "Christopher Nolan",
            duration = "2h 32m"
        ),
        Movie(
            id = 3,
            title = "Inception",
            description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea.",
            rating = 8.8,
            releaseYear = 2010,
            genre = "Sci-Fi",
            posterUrl = "🌀",
            director = "Christopher Nolan",
            duration = "2h 28m"
        ),
        Movie(
            id = 4,
            title = "Pulp Fiction",
            description = "The lives of two mob hitmen, a boxer, a gangster and his wife intertwine in four tales of violence and redemption.",
            rating = 8.9,
            releaseYear = 1994,
            genre = "Crime",
            posterUrl = "🔫",
            director = "Quentin Tarantino",
            duration = "2h 34m"
        ),
        Movie(
            id = 5,
            title = "Forrest Gump",
            description = "The presidencies of Kennedy and Johnson unfold through the perspective of an Alabama man with an IQ of 75.",
            rating = 8.8,
            releaseYear = 1994,
            genre = "Drama",
            posterUrl = "🏃",
            director = "Robert Zemeckis",
            duration = "2h 22m"
        ),
        Movie(
            id = 6,
            title = "The Matrix",
            description = "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
            rating = 8.7,
            releaseYear = 1999,
            genre = "Sci-Fi",
            posterUrl = "🕶️",
            director = "The Wachowskis",
            duration = "2h 16m"
        ),
        Movie(
            id = 7,
            title = "Interstellar",
            description = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            rating = 8.6,
            releaseYear = 2014,
            genre = "Sci-Fi",
            posterUrl = "🚀",
            director = "Christopher Nolan",
            duration = "2h 49m"
        ),
        Movie(
            id = 8,
            title = "Parasite",
            description = "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
            rating = 8.5,
            releaseYear = 2019,
            genre = "Thriller",
            posterUrl = "🏠",
            director = "Bong Joon-ho",
            duration = "2h 12m"
        )
    )

    // Watchlist state
    private val _watchlist = mutableStateListOf<Int>()

    val movies: List<Movie> get() = _movies
    val watchlist: List<Movie> get() = _movies.filter { it.id in _watchlist }

    fun isInWatchlist(movieId: Int): Boolean {
        return movieId in _watchlist
    }

    fun toggleWatchlist(movieId: Int) {
        if (movieId in _watchlist) {
            _watchlist.remove(movieId)
        } else {
            _watchlist.add(movieId)
        }
    }

    fun getMovieById(movieId: Int): Movie? {
        return _movies.find { it.id == movieId }
    }
}