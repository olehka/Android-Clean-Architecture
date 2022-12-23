package com.olehka.cleanandroid.core.domain

import com.olehka.cleanandroid.shared.core.functional.Either
import com.olehka.cleanandroid.shared.core.model.Failure
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val result = async(Dispatchers.IO) {
                run(params)
            }
            onResult(result.await())
        }
    }

    class None
}
