package com.dara.apod

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.list_item_detail.view.*
import kotlinx.android.synthetic.main.list_item_picture.view.*

class PictureAdapter(
    private var pictures: List<Picture>,
    private val context: Context,
    private var isForList: Boolean,
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    //Class to handle item clicks
    interface ItemClickListener {
        fun onItemClick(picture: Picture)
    }

    inner class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        fun bind(picture: Picture) {
            if (isForList) {
                Glide.with(context).load(picture.url).placeholder(R.drawable.placeholder)
                    .into(itemView.img_picture)
                itemView.frame_layout.setOnClickListener(this)
            } else {
                itemView.img_info.setOnClickListener(this)
                Glide.with(context).load(picture.url).placeholder(R.drawable.placeholder)
                    .into(itemView.img_picture_detail)
            }
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val clickedPicture = pictures[position]
            clickListener.onItemClick(clickedPicture)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = when (isForList) {
            true -> inflater.inflate(R.layout.list_item_picture, parent, false)
            else -> inflater.inflate(R.layout.list_item_detail, parent, false)
        }
        return PictureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val currentPicture = pictures[position]
        holder.bind(currentPicture)
    }

    internal fun setPictures(transactions: List<Picture>) {
        this.pictures = transactions
        notifyDataSetChanged()
    }

}