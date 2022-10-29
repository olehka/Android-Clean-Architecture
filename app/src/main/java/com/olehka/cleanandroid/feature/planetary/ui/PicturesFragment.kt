package com.olehka.cleanandroid.feature.planetary.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.olehka.cleanandroid.R
import com.olehka.cleanandroid.core.android.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PicturesFragment : BaseFragment() {
    @Inject
    lateinit var picturesAdapter: PicturesAdapter

    private val viewModel: PicturesViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_pictures

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadPictures()
    }

    private fun initializeView() {
    }

    private fun loadPictures() {
        viewModel.loadPictures()
    }
}
