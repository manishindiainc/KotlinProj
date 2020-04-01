package com.example.kotlinproj

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.security.AccessControlContext

class PersonViewModel(application: Application) : AndroidViewModel(application) {
    val repo : RetroFitRepo
    var data : MutableLiveData<List<Photo>> = MutableLiveData()

    init {
        repo = RetroFitRepo()
    }

    fun getDemoData() : LiveData<List<Photo>>{
        viewModelScope.launch{
            var photList:List<Photo> = loadData();
            data.value = photList
        }
        return data;
    }

    suspend fun loadData() : List<Photo>{
        var photoList : List<Photo>

        photoList = withContext(Dispatchers.Default){
            repo.getData()
        }

        return photoList
    }
}