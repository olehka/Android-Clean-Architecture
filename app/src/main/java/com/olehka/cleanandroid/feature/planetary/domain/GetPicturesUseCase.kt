package com.olehka.cleanandroid.feature.planetary.domain

import com.olehka.cleanandroid.core.interactor.UseCase
import com.olehka.cleanandroid.feature.planetary.PlanetaryRepositoryApi
import com.olehka.cleanandroid.feature.planetary.model.Picture
import javax.inject.Inject

class GetPicturesUseCase @Inject constructor(
    private val planetaryRepositoryApi: PlanetaryRepositoryApi
) : UseCase<List<Picture>, GetPicturesUseCase.Params>() {

    override suspend fun run(params: Params) =
        planetaryRepositoryApi.getPictures(params.startDate, params.endDate)

    data class Params(val startDate: String, val endDate: String)
}
