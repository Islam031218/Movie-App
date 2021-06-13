package com.example.movieapp.retrofit

import java.io.Serializable

data class Page(
     val results : List<Movie>,
)

data class Movie(
    var title: String,
    var overview: String,
    var vote_average: String,
    var release_date: String,
    var poster_path: String
) : Serializable