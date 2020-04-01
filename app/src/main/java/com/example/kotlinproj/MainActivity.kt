package com.example.kotlinproj

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var personViewModel : PersonViewModel
    lateinit var recyclerView : RecyclerView
    lateinit var photoAdapter : PhotoAdapter
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
    }

    fun init(){
        progressBar = findViewById(R.id.progressBar)
        photoAdapter = PhotoAdapter(this)
        recyclerView = findViewById(R.id.recycler_view);
        with(recyclerView){
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter = photoAdapter
        }

        personViewModel = ViewModelProvider(this, PersonViewModelFactory(this.application)).get(PersonViewModel::class.java)
        progressBar.visibility = View.VISIBLE;
        personViewModel.getDemoData().observe(this, Observer {
            progressBar.visibility = View.GONE;
            photoAdapter.updatePhotoList(it)
        })
    }
}
