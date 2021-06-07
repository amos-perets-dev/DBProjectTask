package com.example.dbprojecttask.image_app

import android.content.Context
import androidx.room.Room
import com.example.dbprojecttask.db.room.AppDatabase
import com.example.dbprojecttask.db.room.DATABASE
import com.example.dbprojecttask.image_app.configuration.IImageConfiguration
import com.example.dbprojecttask.image_app.configuration.ImageConfiguration
import com.example.dbprojecttask.managers.IImageManager
import com.example.dbprojecttask.managers.ImageManager
import com.example.dbprojecttask.network.api.ImageApi
import com.example.dbprojecttask.network.base.BaseNetworkManager
import com.example.dbprojecttask.network.base.IBaseNetworkManager
import com.example.dbprojecttask.network.error.HandleNetworkError
import com.example.dbprojecttask.network.error.IHandleNetworkError
import com.example.dbprojecttask.repository.IImagesRepository
import com.example.dbprojecttask.repository.ImagesRepository
import com.example.dbprojecttask.screens.home_page.HomePageViewModel
import com.example.dbprojecttask.screens.home_page.ImagesAdapter
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class ImageModules {
    fun createModules(context: Context): List<Module> {

        val appModules = createAppModules(context)

        val homePageModule = createHomePageModule(context)

        return listOf(appModules, homePageModule)
    }

    private fun createHomePageModule(context: Context): Module {
        return module {
            factory { ImagesAdapter() }

            viewModel {
                HomePageViewModel(get(), get())
            }

        }
    }

    private fun createAppModules(context: Context): Module {

        return module {
            factory<IImageConfiguration> { ImageConfiguration() }
            factory<IHandleNetworkError> { HandleNetworkError() }

            single<IBaseNetworkManager> {
                BaseNetworkManager()
            }

            val roomDb : AppDatabase =  Room.databaseBuilder(context, AppDatabase::class.java, DATABASE)
                .fallbackToDestructiveMigration()
                .build()

            single<IImageManager> {
                 ImageManager(
                    get<IBaseNetworkManager>().buildRetrofit()
                        .create(ImageApi.HomePageApi::class.java)
                )
            }

            single<IImagesRepository> {
                ImagesRepository(roomDb.imageDao, get())
            }

        }
    }


}
