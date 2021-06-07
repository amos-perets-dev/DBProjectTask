package com.example.dbprojecttask.image_app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ImageApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Android context
            androidContext(applicationContext)
            // modules
            modules(ImageModules().createModules(applicationContext))
        }

    }

}