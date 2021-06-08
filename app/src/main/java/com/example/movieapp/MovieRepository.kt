package com.example.movieapp

class MovieRepository {
    fun getPopularMovieList(): MutableList<Movie> {
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        return movieList
    }

    fun getRatedMovieList(): MutableList<Movie> {
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))

        return movieList
    }

    fun getRatingMovieList(): MutableList<Movie> {
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))
        movieList.add(Movie("Movie Titles", "About the book","00.00.00","0.0",151))

        return movieList
    }
    fun getSpecificMovie(): String {
        return "Movie item clicked"
    }
}