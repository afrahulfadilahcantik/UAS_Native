package com.example.buttomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_detail_movie.movie_title
import kotlinx.android.synthetic.main.movie_item.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    var movies: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        movies = intent.getParcelableExtra(EXTRA_DATA)

        movie_title.text = movies?.title
        movie_popularity.text = movies?.popularity
        movie_overview.text = movies?.overview


        Glide.with(img_poster).load(IMAGE_BASE + movies!!.poster).into(img_poster)
    }
}
