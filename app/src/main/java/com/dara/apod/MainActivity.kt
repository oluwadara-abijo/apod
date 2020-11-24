package com.dara.apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<PicturesViewModel>()
    private lateinit var pictureAdapter: PictureAdapter
    private lateinit var pictures: List<Picture>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()

    }

    private fun setupRecyclerview() {
        pictures = listOf()
        val gridlayoutManager = GridLayoutManager(this, 2)
        pictureAdapter = PictureAdapter(pictures, this)
        rv_pictures.apply {
            layoutManager = gridlayoutManager
            adapter = pictureAdapter
        }
        viewModel.pictures.observe(this, Observer {
            pictureAdapter.setPictures(it)
        })
    }
}