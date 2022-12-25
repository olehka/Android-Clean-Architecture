package com.olehka.cleanandroid.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform