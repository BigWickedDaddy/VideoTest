package com.example.mytestapplicationforvideo

import android.app.Application
import com.example.mytestapplicationforvideo.di.AppComponent

class VideoApp: Application() {
    lateinit var appComponent: AppComponent
        private set

//    override fun onCreate() {
//        super.onCreate()
//        appComponent = DaggerAppComponent.builder()
//            .application(this)
//            .build()
//    }
}