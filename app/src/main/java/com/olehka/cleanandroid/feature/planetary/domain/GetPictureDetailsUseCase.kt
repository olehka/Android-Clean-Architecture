package com.olehka.cleanandroid.feature.planetary.domain

import com.olehka.cleanandroid.core.domain.UseCase
import com.olehka.cleanandroid.feature.planetary.PlanetaryRepositoryApi
import com.olehka.cleanandroid.feature.planetary.model.PictureDetails
import javax.inject.Inject

class GetPictureDetailsUseCase @Inject constructor(
    private val planetaryRepositoryApi: PlanetaryRepositoryApi
) : UseCase<PictureDetails, UseCase.None>() {

    override suspend fun run(params: None) = planetaryRepositoryApi.getPictureDetails()
}
