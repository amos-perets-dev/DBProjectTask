package com.example.dbprojecttask.screens.home_page

import android.util.Log
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import coil.load
import com.example.dbprojecttask.R
import com.example.dbprojecttask.data.ImageDataItem
import com.example.dbprojecttask.image_app.base.view_holder.ViewHolderBase
import kotlinx.android.synthetic.main.image_item.view.*

class ImageViewHolder(parent: ViewGroup, @LayoutRes layout: Int) :
    ViewHolderBase<ImageDataItem>(parent, layout) {
    override fun bindData(model: ImageDataItem) {
        Log.d("TEST_GAME", "ImageViewHolder bindData")

        itemView.text_likes_title.text = getText(R.string.home_page_image_likes_title, model.likes)
        itemView.text_comments_title.text = getText(R.string.home_page_image_comments_title, model.comments)

        val url = model.imageUrl
        if (url.isNullOrEmpty().not()){
            itemView.image.load(url)
        }
    }

    private fun getText(@StringRes resString : Int, param : String): String {
        return itemView.resources.getString(resString, param)
    }

}