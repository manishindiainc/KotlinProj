package com.example.kotlinproj

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    suspend fun getPhotos(): Response<List<Photo>>
}