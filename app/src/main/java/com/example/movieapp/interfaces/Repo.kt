package com.example.movieapp.interfaces

import com.example.movieapp.retrofit.Page
import retrofit2.Call

interface Repo {
    fun getComingMovies(api_Key : String, language : String, sort_By : String): Call<Page>
}