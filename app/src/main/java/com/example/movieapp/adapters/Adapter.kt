package com.example.movieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.interfaces.InterfaceClick
import com.example.movieapp.retrofit.Movie
import com.example.movieapp.retrofit.Utils


class Adapter( val movieList: List<Movie>,   val listener : InterfaceClick
) : RecyclerView.Adapter<Adapter.MovieHolder>() {

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val moviePoster: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieAbout: TextView = itemView.findViewById(R.id.movieAbout)
        val movieReleaseDate: TextView = itemView.findViewById(R.id.movieReleaseDate)
        val movieRatings: TextView = itemView.findViewById(R.id.movieRating)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onCardClick(adapterPosition, movieList.get(adapterPosition))
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_model, parent, false)
        return MovieHolder(view)
    }

    val list = movieList

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.itemView.apply {
            val position1 = list.get(position)
            holder.movieTitle.text= position1.title
            holder.movieReleaseDate.text = position1.release_date
            holder.movieRatings.text = position1.vote_average
            holder.movieAbout.text = position1.overview
            Glide.with(context).load(Utils.IMAGE + list[position].poster_path).into(holder.moviePoster)
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}
interface OnMovieClickListener {

}

