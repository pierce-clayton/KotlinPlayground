import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class StandardDeviationTest {

    private val sd = StandardDeviation

    @Test
    fun `standard deviation sample formula`() {
        val testArray = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
        assertEquals(sd.calculate(testArray), 1.5811388300841898)
    }
}