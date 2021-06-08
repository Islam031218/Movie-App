package com.example.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adapter(private val navigation: String,
              private val context: Context,
              private val movieList: MutableList<Movie>,
              private val listener: OnMovieClickListener)
    : RecyclerView.Adapter<Adapter.MovieHolder>() {
    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val moviePoster: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieAbout: TextView = itemView.findViewById(R.id.movieAbout)
        val movieReleaseDate: TextView = itemView.findViewById(R.id.movieReleaseDate)
        val movieRatings:TextView = itemView.findViewById(R.id.movieRating)


        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            if (v == itemView) {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_model, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        Glide.with(context).load(R.drawable.ic_baseline_accessibility_24).into(holder.moviePoster)
        holder.movieTitle.text = movieList[position].movieTitle
        holder.movieAbout.text = movieList[position].movieObout
        holder.movieReleaseDate.text = movieList[position].movieReleaseDate
        holder.movieRatings.text = movieList[position].movieRating
    }
    override fun getItemCount(): Int {
        return movieList.size
    }
}

interface OnMovieClickListener {
    fun onItemClick(position: Int)
}