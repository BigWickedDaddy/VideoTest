package com.example.mytestapplicationforvideo.di

import com.example.mytestapplicationforvideo.VideoApp
import com.example.mytestapplicationforvideo.di.modules.AppModule
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

}
