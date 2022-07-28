package com.example.mytestapplicationforvideo.presentation.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestapplicationforvideo.databinding.ItemBinding
import com.example.mytestapplicationforvideo.domain.models.Video

class VideoHolder(
    private val binding: ItemBinding,
    private val onItemChosenAction: (Int, Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var video: Video? = null

    fun bind(video: Video): Unit {
        this.video = video
        with(binding) {
            tvVideoName.text = video.display_title
            tvDescriptionName.text = video.summary_short
        }
    }

    companion object {
        fun create(parent: ViewGroup, onItemChosenAction: (Int, Int) -> Unit): VideoHolder {
            return VideoHolder(
                ItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ),
                onItemChosenAction
            )
        }
    }
}