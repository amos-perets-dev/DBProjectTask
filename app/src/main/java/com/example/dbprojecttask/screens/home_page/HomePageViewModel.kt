package com.example.dbprojecttask.screens.home_page

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dbprojecttask.data.ImageData
import com.example.dbprojecttask.data.ImageDataItem
import com.example.dbprojecttask.image_app.base.ViewModelBase
import com.example.dbprojecttask.image_app.configuration.IImageConfiguration
import com.example.dbprojecttask.repository.IImagesRepository
import io.reactivex.schedulers.Schedulers

class HomePageViewModel(
    imagesRepository: IImagesRepository,
    private val configuration: IImageConfiguration
) : ViewModelBase() {

    val images = MutableLiveData<List<ImageDataItem>>()

    init {

        imagesRepository
            .initImages()
            ?.subscribeOn(Schedulers.io())
            ?.doOnNext(this::notifyData)
            ?.subscribe({}, Throwable::printStackTrace)?.let {
                compositeDisposable.add(
                    it
                )
            }

        imagesRepository.getImages()
            ?.subscribe({}, Throwable::printStackTrace)?.let {
                compositeDisposable.add(
                    it
                )
            }
    }

    private fun notifyData(list: List<ImageData>) {
        val imagesItems = convertImages(list)
        images.postValue(imagesItems)
    }

    private fun convertImages(list: List<ImageData>): List<ImageDataItem> {
        val dataList = list.filter { imageData ->
            imageData.comments ?: 0 > configuration.getMinimumComments()
                    && imageData.likes ?: 0 > configuration.getMinimumLikes()
        }.map { imageData ->
            ImageDataItem(
                imageData.id ?: 0,
                imageData.imageUrl,
                imageData.likes.toString(),
                imageData.comments.toString()
            )
        }

        return dataList
    }

}