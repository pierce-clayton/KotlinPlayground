import kotlin.math.pow
import kotlin.math.sqrt

object StandardDeviation {
    fun calculate(numArray : DoubleArray): Double{
        val mean = numArray.average()
        val varianceSum = numArray.sumOf { num ->
            (num - mean).pow(2)
        }
        return sqrt(varianceSum / (numArray.size - 1))
    }
}