package com.dara.apod

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dara.apod.DetailActivity.Companion.POSITION
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_picture.*

class MainActivity : AppCompatActivity(), PictureAdapter.ItemClickListener {

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
        pictureAdapter = PictureAdapter(pictures, this, true, this)
        rv_pictures.apply {
            layoutManager = gridlayoutManager
            adapter = pictureAdapter
        }
        viewModel.pictures.observe(this, Observer {
            pictures = it
            pictureAdapter.setPictures(pictures)
        })
    }

    override fun onItemClick(picture: Picture) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(POSITION, pictures.indexOf(picture))
        val options = ActivityOptions.makeSceneTransitionAnimation(
            this,
            img_picture,
            img_picture.transitionName
        )
        startActivity(intent, options.toBundle())
    }

}