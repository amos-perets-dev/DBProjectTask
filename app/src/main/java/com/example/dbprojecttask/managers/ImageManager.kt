package com.example.dbprojecttask.managers

import android.util.Log
import com.example.dbprojecttask.data.ImageData
import com.example.dbprojecttask.network.api.ImageApi
import com.example.dbprojecttask.network.error.IHandleNetworkError
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class ImageManager(
    private val imageApi: ImageApi.HomePageApi
) : IImageManager {


    override fun fetchDataFromServer(): Observable<List<ImageData>>? {
        return imageApi.getImages()
            .subscribeOn(Schedulers.io())
            .map { it.imageList }
    }

}
