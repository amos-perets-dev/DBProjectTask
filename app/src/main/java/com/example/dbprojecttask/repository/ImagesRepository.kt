package com.example.dbprojecttask.repository

import com.example.dbprojecttask.data.ImageData
import com.example.dbprojecttask.data.ImagesListData
import com.example.dbprojecttask.db.room.dao.ImagesDao
import com.example.dbprojecttask.managers.IImageManager
import com.example.dbprojecttask.managers.ImageManager
import io.reactivex.Completable
import io.reactivex.Observable

class ImagesRepository(private val imagesDao: ImagesDao?, private val imageManager: IImageManager) :
    IImagesRepository {


    override fun getImages(): Completable? {
        return imageManager
            .fetchDataFromServer()
            ?.onErrorReturn {
                imagesDao?.getAllImages()
            }
            ?.flatMapCompletable {
                addImages(it)
            }
    }

    override fun initImages(): Observable<List<ImageData>>? {
        return imagesDao?.getAllImagesAsync()
    }

    override fun addImages(imageDataList: List<ImageData>?): Completable? {
        return imagesDao?.insertAllImages(imageDataList)
    }

}