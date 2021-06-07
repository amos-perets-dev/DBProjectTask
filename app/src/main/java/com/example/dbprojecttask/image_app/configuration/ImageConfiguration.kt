package com.example.dbprojecttask.image_app.configuration

class ImageConfiguration : IImageConfiguration {

    companion object {
        private const val MIN_LIKES = 50
        private const val MIN_COMMENTS = 50
    }

    override fun getMinimumComments(): Int = MIN_COMMENTS

    override fun getMinimumLikes(): Int = MIN_LIKES


}