package com.example.mytestapplicationforvideo.di.modules

import dagger.Module

@Module(includes = [
    NetModule::class,
    RepoModule::class
])
class AppModule {

}