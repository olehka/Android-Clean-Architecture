package com.olehka.cleanandroid.feature.planetary

import com.olehka.cleanandroid.core.function.Either
import com.olehka.cleanandroid.core.model.Failure
import com.olehka.cleanandroid.feature.planetary.model.Picture
import com.olehka.cleanandroid.feature.planetary.model.PictureDetails

interface PlanetaryRepositoryApi {

    fun getPictureDetails(): Either<Failure, PictureDetails>

    fun getPictures(): Either<Failure, List<Picture>>
}
