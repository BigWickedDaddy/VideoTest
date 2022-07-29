package com.example.mytestapplicationforvideo.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytestapplicationforvideo.R
import com.example.mytestapplicationforvideo.databinding.FragmentVideoBinding
import com.example.mytestapplicationforvideo.di.assisted.Factory
import com.example.mytestapplicationforvideo.domain.models.Video
import com.example.mytestapplicationforvideo.presentation.activities.MainActivity
import com.example.mytestapplicationforvideo.presentation.extensions.appComponent
import com.example.mytestapplicationforvideo.presentation.mvp.presenter.ListMvpView
import com.example.mytestapplicationforvideo.presentation.mvp.view.ListPresenter
import com.example.mytestapplicationforvideo.presentation.rv.VideoAdapter
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import javax.inject.Inject

class VideoFragment : MvpAppCompatFragment(R.layout.fragment_video), ListMvpView {

    private lateinit var binding: FragmentVideoBinding

    @Inject
    lateinit var adapterFactory: Factory
    lateinit var videoAdapter: VideoAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: ListPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVideoBinding.bind(view)

        hideBackButton()
        initializeRecyclerView()
    }

    private fun hideBackButton() {
        (activity as MainActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
        }
    }

    private fun initializeRecyclerView() {
        videoAdapter = adapterFactory.provideVideoAdapter{
            Glide.with(requireContext())
        }
        
        binding.rvVideos.apply {
            adapter = videoAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.fragment_container),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }


    override fun showTracksList(list: MutableList<Video>) {
        videoAdapter.submitList(list)
    }

    override fun showError() {
        showMessage(getString(R.string.error_message))
    }

    override fun showError(message: String) {
        showMessage(message)
    }

}