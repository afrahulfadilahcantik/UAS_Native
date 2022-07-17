package com.example.buttomnavigation

import retrofit2.Call
import retrofit2.http.GET

interface TvApiInterface {

    @GET("/3/tv/popular?api_key=517debd05896afb46d2b9d862000d48e")
    fun getTvList(): Call<TvResponse>
}