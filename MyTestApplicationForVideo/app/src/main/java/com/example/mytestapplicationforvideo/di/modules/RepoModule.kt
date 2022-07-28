package com.example.mytestapplicationforvideo.di.modules

import com.example.mytestapplicationforvideo.data.repository.VideoRepositoryImpl
import com.example.mytestapplicationforvideo.domain.repository.VideoRepository
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun getVideoRepository(repository: VideoRepositoryImpl):VideoRepository
}