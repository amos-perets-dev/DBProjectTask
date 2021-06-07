package com.example.dbprojecttask.repository

import com.example.dbprojecttask.data.ImageData
import io.reactivex.Completable
import io.reactivex.Observable

interface IImagesRepository {

    fun getImages(): Observable<List<ImageData>>?
    fun initImages(): Observable<List<ImageData>>?
    fun addImages(imageDataList: List<ImageData>?): Completable?
}