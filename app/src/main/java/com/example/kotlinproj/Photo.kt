package com.example.kotlinproj

import androidx.annotation.IntegerRes
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photo(
    @Expose
    @SerializedName("albumId")
    val albumId : Int,
    @Expose
    @SerializedName("id")
    val id : Int,
    @Expose
    @SerializedName("title")
    val title : String,
    @Expose
    @SerializedName("url")
    val url : String,
    @Expose
    @SerializedName("thumbnailUrl")
    val thumbnailUrl : String
)