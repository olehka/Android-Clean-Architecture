package com.olehka.cleanandroid.shared.core.model

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
}
