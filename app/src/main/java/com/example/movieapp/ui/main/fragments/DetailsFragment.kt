package com.example.movieapp.ui.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movieapp.adapters.OnMovieClickListener
import com.example.movieapp.databinding.FragmentDetailsBinding
import com.example.movieapp.retrofit.Movie
import com.example.movieapp.retrofit.Utils

class DetailsFragment : Fragment(), OnMovieClickListener {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        val movie = bundle?.getSerializable("movie") as Movie

        binding.apply {
            Log.i("data", movie.toString())
            DetailTitle.text = movie.title
            descriptions.text = movie.overview
            DetailDate.text = movie.release_date
            DetailAppraisal.text = movie.vote_average.toString()
            context?.let { Glide.with(it).load(Utils.IMAGE+movie.poster_path).into(DetailImage) }
        }
//        val bundle = this.arguments
//        val movie = bundle?.getSerializable("info") as Movie
//        binding.apply {
//            DetailImage.setImageResource(movie.movieId)
//            DetailAppraisal.setText(movie.movieRating)
//            DetailDate.setText(movie.movieReleaseDate)
//            DetailTitle.text = movie.movieTitle
//            descriptions.text = movie.movieObout
//
//        }

    }
    private fun configureRecyclerView(){
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}