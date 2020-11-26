package com.dara.apod.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dara.apod.jsonToObject
import com.dara.apod.model.Picture
import com.dara.apod.readJsonFile

/**
 * Helper class for managing UI-related data (i.e the list of pictures)
 */
class PicturesViewModel(application: Application) : AndroidViewModel(application) {

    val pictures: LiveData<List<Picture>> = liveData {
        emit(loadPictures())
    }

    private fun loadPictures(): List<Picture> {
        val data = getApplication<Application>().readJsonFile("data.json")
        val pictureList = jsonToObject<List<Picture>>(data)
        return pictureList.reversed()
    }

}