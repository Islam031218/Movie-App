package com.example.movieapp

import com.example.movieapp.interfaces.Repo
import com.example.movieapp.retrofit.NetworkUtils
import com.example.movieapp.retrofit.Page
import retrofit2.Call

class MovieRepository(val networkUtils: NetworkUtils) : Repo {
    override fun getComingMovies(api_Key: String, language: String, sort_By: String): Call<Page> {
        return networkUtils.getMovie(api_Key,language,sort_By)
    }

}