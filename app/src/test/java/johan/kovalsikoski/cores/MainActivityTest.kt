package johan.kovalsikoski.cores

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.RepeatedTest

class MainActivityTest {

    private val mainActivity: MainActivity by lazy { MainActivity() }

    @Test
    @RepeatedTest(1000)
    fun `generate random color in 0 to 255 range` () {
        val value = mainActivity.generateValueForColor()
        assertTrue(value in 0..255)
    }
}
