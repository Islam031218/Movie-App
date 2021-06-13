package com.example.movieapp.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface  NetworkUtils{

    @GET("movie")
    fun getMovie(
        @Query("api_key") api_key : String,
        @Query("language") language : String,
        @Query("sort_by") sort_by : String
    ) : Call<Page>

    companion object{
        private var retrofitService : NetworkUtils? = null
        fun getInstance() :NetworkUtils{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(NetworkUtils ::class.java)

            }
            return retrofitService!!
        }
    }

}

