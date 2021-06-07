package com.example.dbprojecttask.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dbprojecttask.data.ImageData
import com.example.dbprojecttask.data.ImagesListData
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface ImagesDao {
    @Query("SELECT * FROM images_data")
    fun getAllImages(): List<ImageData>

    @Query("SELECT * FROM images_data")
    fun getAllImagesAsync(): Observable<List<ImageData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImages(imageDataList: List<ImageData>?) : Completable
}