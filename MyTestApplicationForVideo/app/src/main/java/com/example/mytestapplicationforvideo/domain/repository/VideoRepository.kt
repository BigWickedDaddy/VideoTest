package com.example.mytestapplicationforvideo.domain.repository

import com.example.mytestapplicationforvideo.domain.models.Video

interface VideoRepository {
    suspend fun getAllVideos(): MutableList<Video>
}