package com.example.dbprojecttask.network.api

import com.example.dbprojecttask.BuildConfig
import com.example.dbprojecttask.data.ImagesListData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ImageApi {

    interface HomePageApi {

        companion object {
            const val SUFFIX_URL = "?key=${BuildConfig.API_KEY}&image_type=photo"
        }

        /**
         * Get the all images
         *
         * @return [Observable][ImagesListData]
         */
        @GET
        fun getImages(
            @Url url: String = SUFFIX_URL
        ): Observable<ImagesListData>

    }

}