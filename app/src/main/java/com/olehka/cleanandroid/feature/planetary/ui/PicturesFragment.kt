package com.olehka.cleanandroid.feature.planetary.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehka.cleanandroid.core.android.BaseFragment
import com.olehka.cleanandroid.core.extension.failure
import com.olehka.cleanandroid.core.extension.observe
import com.olehka.cleanandroid.databinding.FragmentPicturesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PicturesFragment : BaseFragment<FragmentPicturesBinding>(FragmentPicturesBinding::inflate) {
    @Inject
    lateinit var picturesAdapter: PicturesAdapter

    private val viewModel: PicturesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(viewModel) {
            observe(pictures, ::renderPicturesList)
            failure(failure, ::renderFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadPictures()
    }

    private fun initializeView() {
        binding.pictureList.layoutManager = LinearLayoutManager(requireContext())
        binding.pictureList.adapter = picturesAdapter
    }

    private fun loadPictures() {
        viewModel.loadPictures()
    }

    private fun renderPicturesList(pictures: List<PictureView>) {
        picturesAdapter.collection = pictures
    }
}
