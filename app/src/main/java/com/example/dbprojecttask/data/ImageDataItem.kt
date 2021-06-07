package com.example.dbprojecttask.data

import androidx.recyclerview.widget.DiffUtil

class ImageDataItem(

    val id : Long = 0,

    val imageUrl: String?,

    val likes: String = "",

    val comments: String = ""

) : DiffUtil.ItemCallback<ImageDataItem>(){
    override fun areItemsTheSame(oldItem: ImageDataItem, newItem: ImageDataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImageDataItem, newItem: ImageDataItem): Boolean {
       return areItemsTheSame(oldItem, newItem)
    }
}