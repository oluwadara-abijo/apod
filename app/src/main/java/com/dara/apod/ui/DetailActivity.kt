package com.dara.apod.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.dara.apod.viewmodel.PicturesViewModel
import com.dara.apod.R
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), PictureAdapter.ItemClickListener {

    companion object {
        const val POSITION = "position"
    }

    private val viewModel by viewModels<PicturesViewModel>()
    private lateinit var pictureAdapter: PictureAdapter
    private lateinit var pictures: List<Picture>
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get intent and extras
        position = intent.getIntExtra(POSITION, 0)
        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        pictures = listOf()
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        pictureAdapter = PictureAdapter(pictures, this, false, this)
        rv_pictures.apply {
            layoutManager = linearLayoutManager
            adapter = pictureAdapter
        }
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_pictures)
        viewModel.pictures.observe(this, {
            pictureAdapter.setPictures(it)
            linearLayoutManager.scrollToPosition(position)

        })
    }

    override fun onItemClick(picture: Picture) {
        val modal = PictureDetailsModal(picture)
        modal.show(this.supportFragmentManager, modal.tag)
    }

}