import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import kotlin.test.assertContentEquals

internal class ChallengesTest {

    private val challenges = Challenges()


    @Nested
    inner class CountDown{
        @Test
        fun `count down from 5`() {
            assertContentEquals(challenges.countDown(5), listOf(5, 4, 3, 2, 1, 0))
        }
    }
    @Nested
    inner class AnyCallBack{
        private val callback: ((Int) -> Boolean) = { it > 3 }
        private val anyCallBackPassList = listOf(1,2,3,4)
        private val anyCallBackFailList = listOf(1,2,3)
        @Test
        fun `anyCallBack passes with list of 1 to 4`() {
            assertTrue(challenges.anyCallback(anyCallBackPassList, callback))
        }
        @Test
        fun `anyCallBack fails with list of 1 to 3`() {
            assertFalse(challenges.anyCallback(anyCallBackFailList, callback))
        }
    }
    @Nested
    inner class RecursivePower{
        @Test
        fun `power 2 with exp 2 equals 4`() {
            assertEquals(challenges.power(2,2), 4)
        }
        @Test
        fun `power 2 with exp 5 equals 32`() {
            assertEquals(challenges.power(2, 5), 32)
        }
    }
    @Nested
    inner class BadFibonacci{
        @Test
        fun `second fibonacci number is 1`() {
            assertEquals(challenges.fibonacci(2), 1)
        }
        @Test
        fun `tenth fibonacci number is 55`() {
            assertEquals(challenges.fibonacci(10), 55)
        }
    }
    @Nested
    inner class FizzBuzz{
        @Test
        fun `fizzBuzz to 35`() {
            val fbTo35 = listOf("1", "2", "Fizz", "4",
                "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11",
                "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz",
                "19", "Buzz", "Fizz", "22", "23", "Fizz", "Buzz",
                "26", "Fizz", "28", "29", "FizzBuzz", "31", "32",
                "Fizz", "34", "Buzz")
            assertContentEquals(challenges.fizzBuzz(35), fbTo35)
        }
    }
    @Nested
    inner class GetAllPairs{
        @Test
        fun `all pairs 0 to 3`() {
            val passList = listOf(Pair(0, 0), Pair(0, 1),
                Pair(0, 2), Pair(0, 3), Pair(1, 0), Pair(1, 1), Pair(1, 2),
                Pair(1, 3), Pair(2, 0), Pair(2, 1), Pair(2, 2), Pair(2, 3),
                Pair(3, 0), Pair(3, 1), Pair(3, 2), Pair(3, 3))
            assertContentEquals(challenges.getAllPairs(3), passList)
        }
    }

    @Nested
    inner class AddUpTo{
        @Test
        fun `all numbers up to two add up to three`() {
            assertEquals(challenges.addUpTo(2), 3)
        }
        @Test
        fun `all numbers up to 5 add up to fifteen`() {
            assertEquals(challenges.addUpTo(5), 15)
        }
    }
    @Nested
    inner class CountUpAndDown{
        @Test
        fun `count with 0 should be one entry`() {
            assertContentEquals(challenges.countUpAndDown(0), listOf(0))
        }
        @Test
        fun `count up and down to 9`() {
            val test = listOf(0,1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1,0)
            assertContentEquals(challenges.countUpAndDown(9), test)
        }
    }
    @Nested
    inner class RecursiveFactorial{
        @Test
        fun `factorial 0 should equal 1`(){
            assertEquals(challenges.factorial(0), 1)
        }
        @Test
        fun `factorial 5 should equal 120`(){
            assertEquals(challenges.factorial(5), 120)
        }
        @Test
        fun `factorial 10 should equal 3628800`(){
            assertEquals(challenges.factorial(10), 3628800)
        }
    }
    @Nested
    inner class FilterOdd{
        @Test
        fun `empty list returns empty list`() {
            assertContentEquals(challenges.filterOdd(listOf()), emptyList())
        }

        @Test
        fun `1, 2, 3 returns 1, 3`() {
            assertContentEquals(challenges.filterOdd(listOf(1, 2, 3)), listOf(1, 3))
        }

        @Test
        fun `2, 49, 2, 5, 4 returns 9, 5`() {
            assertContentEquals(challenges.filterOdd(listOf(2, 9, 2, 5, 4)), listOf(9, 5))
        }

        @Test
        fun `7, 4, 6, 8, 7, 9 returns 7, 7, 9`() {
            assertContentEquals(challenges.filterOdd(listOf(7, 4, 6, 8, 7, 9)), listOf(7, 7, 9))
        }
    }
    @Nested
    inner class PrintNumber{
        @Test
        fun `printNumber 0 return listOf()`() {
            assertContentEquals(challenges.printNumber(0), emptyList())
        }

        @Test
        fun `printNumber 1 return listOf(1)`() {
            assertContentEquals(challenges.printNumber(1), listOf(1))
        }

        @Test
        fun `printNumber 3 return listOf(3, 2, 1)`() {
            assertContentEquals(challenges.printNumber(3), listOf(3, 2, 1))
        }

        @Test
        fun `printNumber 5 return listOf(5, 4, 3, 2, 1)`() {
            assertContentEquals(challenges.printNumber(5), listOf(5, 4, 3, 2, 1))
        }
    }
}