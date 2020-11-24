package com.dara.apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var pictures: List<Picture>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = this.readJsonFile("data.json")
        pictures = jsonToObject(data)
        setupRecyclerview()

    }

    fun setupRecyclerview() {
        val gridlayoutManager = GridLayoutManager(this, 2)
        val pictureAdapter = PictureAdapter(pictures, this)
        rv_pictures.apply {
            layoutManager = gridlayoutManager
            adapter = pictureAdapter
        }
    }
}