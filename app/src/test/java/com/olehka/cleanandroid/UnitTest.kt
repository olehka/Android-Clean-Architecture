package com.olehka.cleanandroid

/**
 * Base class for Unit tests. Inherit from it to create test cases which DO NOT contain android
 * framework dependencies or components.
 */
abstract class UnitTest {

    fun fail(message: String): Nothing = throw AssertionError(message)
}
