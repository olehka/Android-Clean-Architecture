package com.olehka.cleanandroid.feature.planetary.domain

import com.olehka.cleanandroid.core.interactor.UseCase
import com.olehka.cleanandroid.feature.planetary.PlanetaryRepositoryApi
import com.olehka.cleanandroid.feature.planetary.model.Picture
import javax.inject.Inject

class GetPicturesUseCase @Inject constructor(
    private val planetaryRepositoryApi: PlanetaryRepositoryApi
) : UseCase<List<Picture>, UseCase.None>() {

    override suspend fun run(params: None) = planetaryRepositoryApi.getPictures()
}
