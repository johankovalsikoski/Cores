package johan.kovalsikoski.cores

import android.graphics.Color
import androidx.lifecycle.ViewModel
import java.util.*

const val MAX_INT = 255

class MainViewModel(private val random: Random): ViewModel(){

    fun generateValueForColor(): Int = random.nextInt(MAX_INT)

    fun generateColorFromValues(red: Int, green: Int, blue: Int): Int = Color.rgb(red, green, blue)

}