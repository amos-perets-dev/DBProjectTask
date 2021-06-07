package com.example.dbprojecttask.managers

import com.example.dbprojecttask.data.ImageData
import com.example.dbprojecttask.data.ImagesListData
import io.reactivex.Observable

interface IImageManager {

    /**
     * Fetch the data from the server
     */
    fun fetchDataFromServer(): Observable<List<ImageData>>?
}