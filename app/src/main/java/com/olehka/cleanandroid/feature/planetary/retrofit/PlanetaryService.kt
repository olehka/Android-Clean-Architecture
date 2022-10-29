package com.olehka.cleanandroid.feature.planetary.retrofit

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlanetaryService @Inject constructor(retrofit: Retrofit) : PlanetaryApi {
    private val planetaryApi by lazy { retrofit.create(PlanetaryApi::class.java) }

    override fun pictures(startDate: String, endDate: String) =
        planetaryApi.pictures(startDate, endDate)

    override fun pictureDetails(date: String) = planetaryApi.pictureDetails(date)
}
