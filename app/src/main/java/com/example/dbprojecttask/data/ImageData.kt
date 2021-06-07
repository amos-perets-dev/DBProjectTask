package com.example.dbprojecttask.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "images_data")
data class ImageData(

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "roomId")
    val id : Long? = null,

    @SerializedName("webformatURL")
    @ColumnInfo(name = "image_url")
    val imageUrl : String? = null,

    @SerializedName("likes")
    @ColumnInfo(name = "likes")
    val likes : Int? = null,

    @SerializedName("comments")
    @ColumnInfo(name = "comments")
    val comments : Int? = null

)
