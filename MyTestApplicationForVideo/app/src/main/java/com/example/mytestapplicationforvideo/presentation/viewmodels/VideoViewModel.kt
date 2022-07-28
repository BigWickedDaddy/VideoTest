package com.example.mytestapplicationforvideo.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestapplicationforvideo.domain.models.Video
import com.example.mytestapplicationforvideo.domain.usecase.GetAllVideosUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class VideoViewModel @Inject constructor(private val getAllVideosUseCase: GetAllVideosUseCase
) : ViewModel() {

    private var _videoData: MutableLiveData<Result<List<Video>>> = MutableLiveData()
    val videoData: MutableLiveData<Result<List<Video>>> = _videoData

    fun getVideo(){
        viewModelScope.launch {
            try {
                _videoData.value = Result.success(getAllVideosUseCase())
            } catch (ex:Exception){
                _videoData.value = Result.failure(ex)
            }
        }
    }

}