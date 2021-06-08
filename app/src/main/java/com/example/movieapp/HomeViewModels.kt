package com.example.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var liveDataPopularList = MutableLiveData<MutableList<Movie>>()
    private var liveDataRatedList = MutableLiveData<MutableList<Movie>>()
    private var liveDataRatingsList = MutableLiveData<MutableList<Movie>>()
    private var repository: MovieRepository = MovieRepository()

    fun getPopularList(): MutableLiveData<MutableList<Movie>>{
        return liveDataPopularList
    }
    fun getPopularMovieList(){
        liveDataPopularList.value = repository.getPopularMovieList()
    }
    fun getRatedList(): MutableLiveData<MutableList<Movie>>{
        return liveDataRatedList
    }
    fun getRatedMovieList(){
        liveDataRatedList.value = repository.getRatedMovieList()
    }
    fun getRatingsList(): MutableLiveData<MutableList<Movie>>{
        return liveDataRatingsList
    }
    fun getRatingsMovieList(){
        liveDataRatingsList.value = repository.getRatingMovieList()
    }
}