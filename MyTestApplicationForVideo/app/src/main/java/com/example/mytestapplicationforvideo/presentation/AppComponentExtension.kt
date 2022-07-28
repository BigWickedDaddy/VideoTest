package com.example.mytestapplicationforvideo.presentation

import android.content.Context
import com.example.mytestapplicationforvideo.VideoApp
import com.example.mytestapplicationforvideo.di.AppComponent

val Context.appComponent : AppComponent
    get() = when (this) {
        is VideoApp -> appComponent
        else -> this.applicationContext.appComponent
    }
