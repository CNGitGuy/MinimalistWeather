package com.minimalist.weather.kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test() {
        val testCase = TestCase()
        testCase.print()
        testCase.str = "hello"
        testCase.print()
    }

    @Test
    fun testSingleton() {
        SingletonTest.printString()
    }


    class TestCase {
        var str: String? = null

        fun print() {
            println(str?.length)
        }

    }
}
