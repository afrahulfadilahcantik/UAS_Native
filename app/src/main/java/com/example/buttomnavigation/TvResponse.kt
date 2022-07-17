package com.example.buttomnavigation


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse (
    @SerializedName("results")
    val tv : List<Tv>

) : Parcelable {
    constructor() : this(mutableListOf())
}