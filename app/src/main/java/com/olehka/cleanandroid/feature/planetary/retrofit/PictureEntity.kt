package com.olehka.cleanandroid.feature.planetary.retrofit

import com.olehka.cleanandroid.shared.feature.planetary.model.Picture

data class PictureEntity(private val title: String, private val url: String) {

    fun toPicture() = Picture(title, url)
}
