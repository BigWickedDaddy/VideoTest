package com.example.mytestapplicationforvideo.domain.usecase

import com.example.mytestapplicationforvideo.domain.models.Video
import com.example.mytestapplicationforvideo.domain.repository.VideoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllVideosUseCase @Inject constructor(
    private val userDataRepository: VideoRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(): List<Video> {
        return try {
            withContext(dispatcher) {
                userDataRepository.getAllVideos()
            }
        } catch (ex: Exception) {
            throw ex
        }
    }
}