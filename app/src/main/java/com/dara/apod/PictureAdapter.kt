package com.dara.apod

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.list_item_picture.view.*

class PictureAdapter(private val pictures: List<Picture>, private val context: Context) :
    RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    inner class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(picture: Picture) {
            Glide.with(context).load(picture.url).placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.img_picture)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_picture, parent, false)
        return PictureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val currentPicture = pictures[position]
        holder.bind(currentPicture)
    }

}