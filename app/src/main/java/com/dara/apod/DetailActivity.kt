package com.dara.apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private val viewModel by viewModels<PicturesViewModel>()
    private lateinit var pictureAdapter: PictureAdapter
    private lateinit var pictures: List<Picture>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        pictures = listOf()
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        pictureAdapter = PictureAdapter(pictures, this, false, null)
        rv_pictures.apply {
            layoutManager = linearLayoutManager
            adapter = pictureAdapter
        }
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_pictures)
        viewModel.pictures.observe(this, Observer {
            pictureAdapter.setPictures(it)
        })
    }

}