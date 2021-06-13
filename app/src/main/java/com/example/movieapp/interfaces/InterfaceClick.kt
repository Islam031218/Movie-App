package com.example.movieapp.interfaces

import com.example.movieapp.retrofit.Movie

interface InterfaceClick{

    fun onCardClick(position: Int, movie: Movie)
    fun onFavClick(position: Int)
}
