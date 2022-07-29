package com.example.mytestapplicationforvideo.presentation.mvp.view

import com.example.mytestapplicationforvideo.domain.usecase.GetAllVideosUseCase
import com.example.mytestapplicationforvideo.presentation.mvp.presenter.ListMvpView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.HttpException
import javax.inject.Inject

@InjectViewState
class ListPresenter @Inject constructor(
    private val getAllVideosUseCase: GetAllVideosUseCase
) : MvpPresenter<ListMvpView>(){
    private val disposables = CompositeDisposable()

    fun getTrackListByCountry(country: String, amount: Int) {
        disposables += getAllVideosUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(
                onNext = { list ->
                    viewState.showTracksList(list)
                },
                onError = { error ->
                    if (error is HttpException) {
                        viewState.showError("Unable to get info due http error. Code = ${error.code()}")
                    } else {
                        viewState.showError("There was some error getting chart tracks for country = '$country', sorry :(")
                    }
                })
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}