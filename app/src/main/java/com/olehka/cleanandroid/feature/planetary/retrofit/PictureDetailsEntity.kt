package com.olehka.cleanandroid.feature.planetary.retrofit

import com.olehka.cleanandroid.feature.planetary.model.PictureDetails

data class PictureDetailsEntity(
    private val title: String,
    private val explanation: String,
    private val url: String
) {

    fun toPictureDetails() = PictureDetails(title, explanation, url)
}
