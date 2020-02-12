package johan.kovalsikoski.cores


import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(JUnit4::class)
class MainActivityTest: KoinTest {

    private val viewModel by inject<MainViewModel>()

    fun setup() {
        startKoin {
            modules(
                listOf(
                    mainViewModelModule
                )
            )
        }
    }

    @AfterEach
    fun cleanUp() {
        stopKoin()
    }

    @Test
    @RepeatedTest(1000)
    fun `generate random color in 0 to 255 range` () {
        setup()
        val value = viewModel.generateValueForColor()
        assertTrue(value in 0..255)
    }

}
