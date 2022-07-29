package com.example.mytestapplicationforvideo.data.repository

import android.util.Log
import com.example.mytestapplicationforvideo.data.api.VideoAPI
import com.example.mytestapplicationforvideo.data.api.VideoMapper
import com.example.mytestapplicationforvideo.domain.models.Video
import com.example.mytestapplicationforvideo.domain.repository.VideoRepository
import retrofit2.HttpException
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val api: VideoAPI,
    private val mapper: VideoMapper,
):VideoRepository {

//    override fun getAllVideos():Observable<MutableList<Video>>{
//        try {
//            Log.e("VIDEO DATA REPO", "SENDING REQUEST")
//            val videoResponse = api.getVideo()
//
//            return mapper.map(videoResponse)
//
//        } catch (ex: HttpException) {
//            ex.printStackTrace()
//            Log.e("VideoRepo", "Video Exception: ${ex.message()}")
//            throw ex
//        }
//    }

    override fun getAllVideos():Observable<MutableList<Video>>{
        var response = api.getVideo().toObservable()

        return response.map {
            mapper.map(it)
        }

    }

}