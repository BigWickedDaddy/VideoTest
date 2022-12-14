package com.example.mytestapplicationforvideo.presentation.rv

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.example.mytestapplicationforvideo.domain.models.Video
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


class VideoAdapter @AssistedInject constructor(
    @Assisted("glide")
    private val glide: RequestManager,
) : ListAdapter<Video, VideoHolder>(DiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VideoHolder.create(parent, glide)

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffUtilItemCallback : DiffUtil.ItemCallback<Video>() {
    override fun areItemsTheSame(oldItem: Video, newItem: Video)
            = oldItem.display_title == newItem.display_title

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Video, newItem: Video)
            = oldItem == newItem
}