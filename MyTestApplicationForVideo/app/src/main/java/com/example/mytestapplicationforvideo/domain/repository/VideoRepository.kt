package com.example.mytestapplicationforvideo.domain.repository

import com.example.mytestapplicationforvideo.domain.models.Video
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface VideoRepository {
    fun getAllVideos(): Observable<MutableList<Video>>
}