package com.olehka.cleanandroid.feature.planetary

import com.olehka.cleanandroid.core.function.Either
import com.olehka.cleanandroid.core.model.Failure
import com.olehka.cleanandroid.core.network.request
import com.olehka.cleanandroid.feature.planetary.model.Picture
import com.olehka.cleanandroid.feature.planetary.model.PictureDetails
import com.olehka.cleanandroid.feature.planetary.retrofit.PictureDetailsEntity
import com.olehka.cleanandroid.feature.planetary.retrofit.PlanetaryService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlanetaryRepository @Inject constructor(private val service: PlanetaryService) :
    PlanetaryRepositoryApi {
    override fun getPictures(): Either<Failure, List<Picture>> {
        return service.pictures("2015-06-03", "2015-06-04", "DEMO_KEY").request(
            { it.map { pictureEntity -> pictureEntity.toPicture() } },
            emptyList()
        )
    }

    override fun getPictureDetails(): Either<Failure, PictureDetails> {
        return service.pictureDetails("2015-06-03").request(
            { it.toPictureDetails() },
            PictureDetailsEntity.empty
        )
    }
}
