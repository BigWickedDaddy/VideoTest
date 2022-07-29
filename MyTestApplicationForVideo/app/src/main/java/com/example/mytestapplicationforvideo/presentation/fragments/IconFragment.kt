package com.example.mytestapplicationforvideo.presentation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.replace
import com.example.mytestapplicationforvideo.R
import com.example.mytestapplicationforvideo.databinding.ActivityMainBinding
import com.example.mytestapplicationforvideo.databinding.FragmentIconBinding
import com.example.mytestapplicationforvideo.presentation.extensions.appComponent

class IconFragment : Fragment() {

    private lateinit var binding: FragmentIconBinding

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIconBinding.bind(view)

        initBtnListeners()
    }

    private fun initBtnListeners() {
        with(binding) {
            btnIcon.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace<VideoFragment>(R.id.fragment_container)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

}