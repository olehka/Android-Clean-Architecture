package com.olehka.cleanandroid.core.network

import com.olehka.cleanandroid.shared.core.functional.Either
import com.olehka.cleanandroid.shared.core.model.Failure
import retrofit2.Call

fun <T, R> Call<T>.request(transform: (T) -> R, default: T): Either<Failure, R> {
    return try {
        val response = execute()
        when (response.isSuccessful) {
            true -> Either.Right(transform((response.body() ?: default)))
            false -> Either.Left(Failure.ServerError)
        }
    } catch (exception: Throwable) {
        Either.Left(Failure.ServerError)
    }
}
