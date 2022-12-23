package com.olehka.cleanandroid.shared.core.functional

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Left] or [Right].
 * FP Convention dictates that [Left] is used for "failure"
 * and [Right] is used for "success".
 */
sealed class Either<out L, out R> {
    data class Left<out L>(val a: L) : Either<L, Nothing>()
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun <L> left(a: L) = Left(a)
    fun <R> right(b: R) = Right(b)

    fun fold(fnL: (L) -> Any, fnR: (R) -> Any): Any =
        when (this) {
            is Left -> fnL(a)
            is Right -> fnR(b)
        }
}

/**
 * Composes 2 functions
 * https://proandroiddev.com/kotlins-nothing-type-946de7d464fb
 */
fun <A, B, C> ((A) -> B).compose(f: (B) -> C): (A) -> C = {
    f(this(it))
}

/**
 * Right-based flatMap() FP convention which means that Right is the default case to operate on.
 * If it is Left, operation returns the Left value unchanged.
 */
fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Either.Left -> Either.Left(a)
        is Either.Right -> fn(b)
    }

/**
 * Right-based map() FP convention which means that Right is the default case to operate on.
 * If it is Left, operation returns the Left value unchanged.
 */
fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = this.flatMap(fn.compose(::right))

/**
 * Returns the value from this `Right` or the given [default] if this is a `Left`.
 */
fun <L, R> Either<L, R>.getOrElse(default: R): R =
    when (this) {
        is Either.Left -> default
        is Either.Right -> b
    }

/**
 * Returns the value from this `Right` or Null if this is a `Left`.
 */
fun <L, R> Either<L, R>.orNull(): R? =
    when (this) {
        is Either.Left -> null
        is Either.Right -> b
    }

/**
 * Left-biased onFailure() FP convention dictates that when this class is Left, it'll perform
 * the onFailure functionality passed as a parameter, but, overall will still return an either
 * object so you chain it with other operations.
 */
fun <L, R> Either<L, R>.onFailure(fn: (failure: L) -> Unit): Either<L, R> =
    this.apply { if (this is Either.Left) fn(a) }

/**
 * Right-biased onSuccess() FP convention dictates that when this class is Right, it'll perform
 * the onSuccess functionality passed as a parameter, but, overall will still return an either
 * object so you chain it with other operations.
 */
fun <L, R> Either<L, R>.onSuccess(fn: (success: R) -> Unit): Either<L, R> =
    this.apply { if (this is Either.Right) fn(b) }
