package com.example.mytestapplicationforvideo.domain.usecase

import com.example.mytestapplicationforvideo.domain.models.Video
import com.example.mytestapplicationforvideo.domain.repository.VideoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetAllVideosUseCase @Inject constructor(
    private val userDataRepository: VideoRepository,
) {
        operator fun invoke(): Observable<MutableList<Video>> =
            userDataRepository.getAllVideos()

}
