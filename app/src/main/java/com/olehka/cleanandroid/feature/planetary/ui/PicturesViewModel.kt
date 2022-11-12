package com.olehka.cleanandroid.feature.planetary.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.olehka.cleanandroid.core.android.BaseViewModel
import com.olehka.cleanandroid.core.extension.minusDays
import com.olehka.cleanandroid.feature.planetary.domain.GetPicturesUseCase
import com.olehka.cleanandroid.feature.planetary.model.Picture
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PicturesViewModel @Inject constructor(
    private val getPicturesUseCase: GetPicturesUseCase,
) : BaseViewModel() {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val _pictures = MutableLiveData<List<PictureView>>()
    val pictures: LiveData<List<PictureView>> = _pictures

    fun loadPictures() {
        val calendar = Calendar.getInstance()
        val startDate = calendar.minusDays(7).let { dateFormat.format(it) }
        val endDate = calendar.minusDays(0).let { dateFormat.format(it) }
        val params = GetPicturesUseCase.Params(startDate, endDate)
        getPicturesUseCase(params, viewModelScope) {
            it.fold(::handleFailure, ::handlePictures)
        }
    }

    private fun handlePictures(pictures: List<Picture>) {
        _pictures.value = pictures.map { PictureView(it.title) }
    }
}
