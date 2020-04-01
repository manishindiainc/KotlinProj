package com.example.kotlinproj

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PhotoAdapter(private val context : Context) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    var photoList : ArrayList<Photo>

    init{
        photoList = ArrayList();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.photo_list_item, parent, false)
        view.setOnClickListener {

        }
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindData(context, photoList[position])
    }

    fun updatePhotoList(list : List<Photo>){
        photoList.clear();
        photoList.addAll(list);
        notifyDataSetChanged()
    }

    class PhotoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var textView : TextView
        var imageView : ImageView
        init {
            textView = itemView.findViewById<TextView>(R.id.titleView)
            imageView = itemView.findViewById<ImageView>(R.id.imageView)
        }
       fun bindData(context : Context, photo : Photo){
            textView.text = photo.title

           Picasso.get()
               .load(photo.thumbnailUrl) // load the image
               .error(R.drawable.dummy_image)
               .into(imageView)
       }
    }
}