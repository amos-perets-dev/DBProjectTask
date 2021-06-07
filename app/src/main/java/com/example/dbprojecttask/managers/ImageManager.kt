package com.example.dbprojecttask.managers

import android.util.Log
import com.example.dbprojecttask.data.ImageData
import com.example.dbprojecttask.data.ImagesListData
import com.example.dbprojecttask.data.Result
import com.example.dbprojecttask.network.api.ImageApi
import com.example.dbprojecttask.network.error.HandleNetworkError
import com.example.dbprojecttask.network.error.IHandleNetworkError
import com.example.dbprojecttask.repository.IImagesRepository
import com.example.dbprojecttask.subscribePro
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class ImageManager(
    private val imageApi: ImageApi.HomePageApi,
    private val handleNetworkError: IHandleNetworkError
) : IImageManager {

    private val imageResult = BehaviorSubject.create<Result>()

    init {
        Log.d("TEST_GAME", "ImageManager init")
    }

    fun getError(): Observable<Result> = imageResult.hide()

    override fun fetchDataFromServer(): Observable<List<ImageData>>? {
        return imageApi.getImages()
            .subscribeOn(Schedulers.io())
            .map { it.imageList }
    }

}
