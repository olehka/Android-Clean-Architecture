package com.olehka.cleanandroid.feature.planetary

import com.olehka.cleanandroid.shared.core.functional.Either
import com.olehka.cleanandroid.shared.core.model.Failure
import com.olehka.cleanandroid.core.network.request
import com.olehka.cleanandroid.shared.feature.planetary.model.Picture
import com.olehka.cleanandroid.shared.feature.planetary.model.PictureDetails
import com.olehka.cleanandroid.feature.planetary.retrofit.PictureDetailsEntity
import com.olehka.cleanandroid.feature.planetary.retrofit.PlanetaryService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlanetaryRepository @Inject constructor(private val service: PlanetaryService) :
    PlanetaryRepositoryApi {
    override fun getPictures(startDate: String, endDate: String): Either<Failure, List<Picture>> {
        return service.pictures(startDate, endDate).request(
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
