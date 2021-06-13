package com.example.movieapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.retrofit.NetworkUtils
import com.example.movieapp.retrofit.Page
import com.example.movieapp.retrofit.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var liveDataPopularList = MutableLiveData<Page>()
    private var repository: MovieRepository = MovieRepository(NetworkUtils.getInstance())

    fun getMovie(){
        repository.getComingMovies(Utils.API_KEY,"ru","popularity.desc")
            .enqueue(object  : Callback<Page> {
                override fun onResponse(call: Call<Page>, response: Response<Page>) {
                    if (response.isSuccessful) {
                        val movie = response.body()
                        Log.i("MyTag", movie.toString())
                        liveDataPopularList.value = movie!!
                    }
                }

                override fun onFailure(call: Call<Page>, t: Throwable) {
                    Log.i("MyTag",t.message.toString())
                }
            })
    }

}


