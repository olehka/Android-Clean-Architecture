package com.olehka.cleanandroid.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.olehka.cleanandroid.core.model.Failure

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T) -> Unit) =
    liveData.observe(this) { body(it) }

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure) -> Unit) =
    liveData.observe(this) { body(it) }
