package com.example.movieexplorer.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Double,
    val releaseYear: Int,
    val genre: String,
    val posterUrl: String,
    val director: String,
    val duration: String
)