package com.example.mytestapplicationforvideo.presentation.mvp.presenter

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface CommonMvpView : MvpView {
    @Skip
    fun showError()
    @Skip
    fun showError(message: String)
}