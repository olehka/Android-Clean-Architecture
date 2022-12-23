package com.olehka.cleanandroid.feature.planetary

import com.olehka.cleanandroid.shared.core.functional.Either
import com.olehka.cleanandroid.shared.core.model.Failure
import com.olehka.cleanandroid.feature.planetary.model.Picture
import com.olehka.cleanandroid.feature.planetary.model.PictureDetails

interface PlanetaryRepositoryApi {

    fun getPictureDetails(): Either<Failure, PictureDetails>

    fun getPictures(startDate: String, endDate: String): Either<Failure, List<Picture>>
}
