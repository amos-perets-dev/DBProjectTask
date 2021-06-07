package com.example.dbprojecttask.screens.home_page

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dbprojecttask.R
import com.example.dbprojecttask.data.ImageDataItem

class ImagesAdapter : ListAdapter<ImageDataItem, ImageViewHolder>(ImageDiff) {

    object ImageDiff : DiffUtil.ItemCallback<ImageDataItem>() {
        override fun areContentsTheSame(oldItem: ImageDataItem, newItem: ImageDataItem): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

        override fun areItemsTheSame(oldItem: ImageDataItem, newItem: ImageDataItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(parent, R.layout.image_item)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

}