package com.example.mytestapplicationforvideo.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import com.bumptech.glide.Glide
import com.example.mytestapplicationforvideo.R
import com.example.mytestapplicationforvideo.databinding.ActivityMainBinding
import com.example.mytestapplicationforvideo.databinding.ActivityVideoBinding
import com.example.mytestapplicationforvideo.databinding.ItemBinding
import com.example.mytestapplicationforvideo.di.assisted.Factory
import com.example.mytestapplicationforvideo.domain.models.Video
import com.example.mytestapplicationforvideo.presentation.rv.VideoAdapter
import com.example.mytestapplicationforvideo.presentation.viewmodels.VideoViewModel
import javax.inject.Inject

class VideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    private lateinit var secondBinding: ItemBinding

    @Inject
    lateinit var adapterFactory: Factory
    lateinit var videoAdapter: VideoAdapter

    @Inject
    lateinit var viewModel: VideoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
    }

    override fun onStart() {
        super.onStart()
        startDownloadingData()
        initRecyclerView()
        initObservers()
    }

    private fun startDownloadingData() {
        viewModel.getVideo()
    }

    private fun initRecyclerView() {
        with(binding) {
            videoAdapter = adapterFactory.provideVideoAdapter(
                Glide.with(requireContext())
            ) {
            }
            rvVideos.apply {
                adapter = videoAdapter
            }
        }
    }

    private fun initObservers() {
        viewModel.videoData.observe(this) {
            it.fold(
                onSuccess = { video ->
                    updateRecyclerAndView(video)
                },
                onFailure = {
                    Log.e("ERROR ACTIVITY", "UNABLE TO GET DATA FROM VIEW - VIDEO")
                }
            )
        }
    }

    private fun updateRecyclerAndView(video: List<Video>) {
        videoAdapter.submitList(video)
        secondBinding.tvCounter.text = video.size.toString()
    }

}