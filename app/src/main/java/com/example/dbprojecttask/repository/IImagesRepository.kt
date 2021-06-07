package com.example.dbprojecttask.repository

import com.example.dbprojecttask.data.ImageData
import io.reactivex.Completable
import io.reactivex.Observable

interface IImagesRepository {

    fun getImages(): Completable?
    fun initImages(): Observable<List<ImageData>>?
    fun addImages(imageDataList: List<ImageData>?): Completable?
}