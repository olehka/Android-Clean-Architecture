package com.olehka.cleanandroid.feature.planetary.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.olehka.cleanandroid.core.android.BaseViewModel
import com.olehka.cleanandroid.core.interactor.UseCase
import com.olehka.cleanandroid.feature.planetary.domain.GetPicturesUseCase
import com.olehka.cleanandroid.feature.planetary.model.Picture
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PicturesViewModel @Inject constructor(
    private val getPicturesUseCase: GetPicturesUseCase,
) : BaseViewModel() {
    private val _pictures = MutableLiveData<List<PictureView>>()
    val pictures: LiveData<List<PictureView>> = _pictures

    fun loadPictures() {
        getPicturesUseCase(UseCase.None(), viewModelScope) {
            it.fold(::handleFailure, ::handlePictures)
        }
    }

    private fun handlePictures(pictures: List<Picture>) {
        _pictures.value = pictures.map { PictureView(it.title) }
    }
}
