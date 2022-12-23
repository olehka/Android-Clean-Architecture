package com.olehka.cleanandroid.feature.planetary.retrofit

import com.olehka.cleanandroid.shared.feature.planetary.model.PictureDetails

data class PictureDetailsEntity(
    private val title: String,
    private val explanation: String,
    private val url: String
) {
    companion object {
        val empty = PictureDetailsEntity("", "", "")
    }

    fun toPictureDetails() = PictureDetails(title, explanation, url)
}
