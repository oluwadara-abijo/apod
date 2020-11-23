package com.dara.apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dara.apod.model.Picture
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = this.readJsonFile("data.json")
        tv_hello.text = data

        val pictures = jsonToObject<List<Picture>>(data)
        println("Result - $pictures")


    }
}