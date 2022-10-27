package com.olehka.cleanandroid.feature.planetary.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PlanetaryApi {
    companion object {
        const val BASE_URL = "https://api.nasa.gov/"
        const val API_KEY = "DEMO_KEY"
        const val DATE = "2019-03-02"
        const val APOD_URL = "planetary/apod"
    }

    @GET(APOD_URL)
    fun pictureDetails(@Query("date") date: String): Call<PictureDetailsEntity>

    @GET(APOD_URL)
    fun pictures(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
    ): Call<List<PictureEntity>>
}
