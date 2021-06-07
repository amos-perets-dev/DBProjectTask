package com.example.dbprojecttask.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "images_list_data")
data class ImagesListData(

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "roomId")
    val roomId : Long? = null,

    @SerializedName("hits")
    @ColumnInfo(name = "image_list")
    val imageList : List<ImageData>? = null
)
