package com.example.mytestapplicationforvideo.data.api

import com.example.mytestapplicationforvideo.data.api.response.Result
import com.example.mytestapplicationforvideo.data.api.response.nytimes
import com.example.mytestapplicationforvideo.domain.models.Video
import javax.inject.Inject

class VideoMapper @Inject constructor() {

    fun map(response: nytimes): MutableList<Video> {
        var list = ArrayList<Video>()
        val video = response

        var counter = 0
        for(item in response.results){
            list.add(
                Video(
                    response.results[counter].display_title,
                    response.results[counter].multimedia.src,
                    response.results[counter].summary_short
            ))
            counter++
        }
        counter = 0

        return list
    }
}