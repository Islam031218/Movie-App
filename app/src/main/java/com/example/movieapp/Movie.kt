package com.example.movieapp

data class Movie(
    val movieTitle: String,
    val movieObout: String,
    val movieReleaseDate: String,
    val movieRating: String,
    val movieId : Int){

    constructor(movieTitle: String,movieObout: String,movieReleaseDate: String,movieRating: Double)
            : this("movieTitle","movieObout","00.00.00",
        "0.0",151) {

    }
}