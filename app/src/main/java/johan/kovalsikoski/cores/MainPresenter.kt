package johan.kovalsikoski.cores

import android.graphics.Color
import java.util.*

class MainPresenter: MainContract.Presenter {

    private val random: Random by lazy { Random() }

    override fun generateValueForColor(): Int = random.nextInt(MAX_INT)

    override fun generateColorFromValues(red: Int, green: Int, blue: Int): Int = Color.rgb(red, green, blue)

}