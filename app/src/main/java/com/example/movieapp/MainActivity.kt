package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.ui.main.fragments.FavoriteFragment
import com.example.movieapp.ui.main.fragments.RatingsFragment
import com.example.movieapp.ui.main.HomeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragmentContainer(HomeFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home -> setFragmentContainer(HomeFragment())
                R.id.favorite -> setFragmentContainer(FavoriteFragment())
                R.id.rating -> setFragmentContainer(RatingsFragment())
            }
            true
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_menu, menu)
        return true
    }

    private fun setFragmentContainer(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}