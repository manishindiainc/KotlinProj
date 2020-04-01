package com.example.kotlinproj

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetroFitRepo{

    suspend fun getData():List<Photo>{
       val response : Response<List<Photo>> = ApiClient.getClient.getPhotos()
        if(response.isSuccessful){
            return response.body() ?: ArrayList<Photo>()
        }

        return ArrayList<Photo>();
    }
}