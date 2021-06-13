package com.example.movieapp.ui.main
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.*
import com.example.movieapp.adapters.Adapter
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.interfaces.InterfaceClick
import com.example.movieapp.retrofit.Movie
import com.example.movieapp.ui.main.fragments.DetailsFragment

class HomeFragment : Fragment(), InterfaceClick {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel
    lateinit var adapter : Adapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel ::class.java)
        viewModel.getMovie()
        viewModel.liveDataPopularList.observe(viewLifecycleOwner,{
            configureRecyclerView(it.results)
        })
    }

    private fun configureRecyclerView(list: List<Movie>){
        binding.apply { movieListPopular.layoutManager = LinearLayoutManager(
            view?.context,
            LinearLayoutManager.HORIZONTAL, false
        )
            adapter = Adapter( list, this@HomeFragment)
            movieListPopular.adapter = adapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCardClick(position: Int , movie: Movie) {
        viewModel.apply {

        }
        parentFragmentManager.beginTransaction().apply {
            val bundle = Bundle()
            bundle.putSerializable("movie", movie)
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            replace(R.id.fragment_container,fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onFavClick(position: Int) {
        TODO("Not yet implemented")
    }


}


