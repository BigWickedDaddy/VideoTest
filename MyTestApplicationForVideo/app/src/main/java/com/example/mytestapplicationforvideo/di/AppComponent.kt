package com.example.mytestapplicationforvideo.di

import com.example.mytestapplicationforvideo.VideoApp
import com.example.mytestapplicationforvideo.di.modules.AppModule
import com.example.mytestapplicationforvideo.presentation.activities.MainActivity
import com.example.mytestapplicationforvideo.presentation.fragments.IconFragment
import com.example.mytestapplicationforvideo.presentation.fragments.VideoFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: VideoApp): Builder
        fun build(): AppComponent
    }

    fun inject(application: VideoApp)
    fun inject(mainActivity: MainActivity)
    fun inject(videoFragment: VideoFragment)
    fun inject(iconFragment: IconFragment)

}
