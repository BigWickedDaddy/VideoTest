package com.example.mytestapplicationforvideo.data.api

import com.example.mytestapplicationforvideo.data.api.response.nytimes
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface VideoAPI {

    @GET("https://api.nytimes.com/svc/movies/v2/reviews/all.json")
    fun getVideo(): Single<nytimes>

}