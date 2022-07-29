package com.example.mytestapplicationforvideo.presentation.mvp.presenter

import com.example.mytestapplicationforvideo.domain.models.Video
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ListMvpView : CommonMvpView {
    fun showLoading()
    fun hideLoading()
    fun showTracksList(list: MutableList<Video>)
}