package com.olehka.cleanandroid.core.model

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
}
