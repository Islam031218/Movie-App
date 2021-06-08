package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), OnMovieClickListener {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        movieModel.getPopularMovieList()
        movieModel.getRatedMovieList()
        movieModel.getRatingsMovieList()

        movieModel.getPopularList().observe(viewLifecycleOwner, {configurePopularList(it)})
        movieModel.getRatedList().observe(viewLifecycleOwner, {configureRatedList(it)})
        movieModel.getRatingsList().observe(viewLifecycleOwner, {configureRatingsList(it)})
    }

    private fun configurePopularList(movieList: MutableList<Movie>){
        binding.movieListPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.movieListPopular.setHasFixedSize(true)
        binding.movieListPopular.adapter = Adapter("Popular", requireContext(), movieList, this)
    }
    private fun configureRatedList(movieList: MutableList<Movie>){
        binding.movieListRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.movieListRated.setHasFixedSize(true)
        binding.movieListRated.adapter = Adapter("Rated", requireContext(), movieList, this)
    }
    private fun configureRatingsList(movieList: MutableList<Movie>){
        binding.movieListRatings.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.movieListRatings.setHasFixedSize(true)
        binding.movieListRatings.adapter = Adapter("Ratings", requireContext(), movieList, this)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
    }
}


