package com.example.mytestapplicationforvideo.di.assisted

import com.bumptech.glide.RequestManager
import com.example.mytestapplicationforvideo.presentation.rv.VideoAdapter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface Factory {
    fun provideVideoAdapter(
        @Assisted("glide") glide: () -> RequestManager
    ):VideoAdapter
}