package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.databinding.FragmentDetailsBinding

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
    }
    private fun configureRecyclerView(){
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    // для того чтоб не произошла утечка данных
    override fun onItemClick(position: Int) {
    }
}