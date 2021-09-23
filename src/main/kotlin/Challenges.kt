
class Challenges {
    // Given positive integer `n` implement a function which returns a list containing all steps from `n` to `0`.
    fun countDown(n: Int): List<Int> {
        return (n downTo 0).toList()
    }
    /*
    Given list of integers and callback implement a **recursive** function which returns `true` if simple value in the list
    passed to callback returns `true`, otherwise return `false`.
     */
    fun anyCallback(list: List<Int>, callback: (Int) -> Boolean): Boolean {
        return with(list){
            when(size){
                1-> callback(first())
                else -> anyCallback(drop(1), callback)
            }
        }
    }
    /*
    Given positive integer `base` and positive integer `exponent` implement a function which calculates power of base of
    exponent. This function should mimic functionality of `Math.pow`.
     */
    fun power(base: Int, exponent: Int): Int {
        return when (exponent) {
            1 -> base
            else -> base * power(base, exponent -1)
        }
    }
    /*
    Print out the n-th entry in the fibonacciSequence series. The
    [fibonacci](https://en.wikipedia.org/wiki/Fibonacci_number) series is an ordering of numbers where each number is the
    sum of the preceding two. For example, the sequence `[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]` forms the first ten entries of
    the fibonacci sequence.
     */
    fun fibonacci(n: Int): Int {
        return when (n){
            0 -> 0
            1 -> 1
            2 -> 1
            else -> fibonacci(n - 1) + fibonacci(n - 2)
        }
    }

    /*
    Given positive integer `n` implement a function which returns a list numbers from `1` to `100`. However for multiples of
    three list should contain word `Fizz` instead of the number and for the multiples of five list should contain
    word `Buzz`. For numbers which are multiples of both three and five list should contain `FizzBuzz` word.
     */
    fun fizzBuzz(n: Int): List<String> {
        return mutableListOf<String>().apply {
            (1..n).forEach {
                when{
                    it % 15 == 0 -> this.add("FizzBuzz")
                    it % 5 == 0 -> this.add("Buzz")
                    it % 3 == 0 -> this.add("Fizz")
                    else -> this.add(it.toString())
                }
            }
        }
    }
    /*
    Given positive Int `n` implement a function which returns a list of containing pairs with all combinations of numbers
    from `0` to `n`.
     */
    fun getAllPairs(n: Int): List<Pair<Int, Int>> {
        return mutableListOf<Pair<Int, Int>>().apply {
            (0..n).forEach { i ->
                (0..n).forEach { j ->
                    this.add(Pair(i, j))
                }
            }
        }
    }
    //Given positive integer `n` implement a function which calculates sum of all numbers from `1` up to (and including)
    //number `n`.
    fun addUpTo(n: Int): Int {
        return (1..n).toList().sum()
    }
}