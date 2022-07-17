package com.example.buttomnavigation

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=95f3402f8fbdd80e11f7093cbe09a4f8")
    fun getMovieList(): Call<MovieResponse>
}

