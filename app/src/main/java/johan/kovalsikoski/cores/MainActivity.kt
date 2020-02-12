package johan.kovalsikoski.cores

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sb_red.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                v_color_result.setBackgroundColor(viewModel.generateColorFromValues(progress, sb_green.progress, sb_blue.progress))
                updateLabelRed(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) { }

            override fun onStopTrackingTouch(p0: SeekBar?) { }

        })

        sb_green.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                v_color_result.setBackgroundColor(viewModel.generateColorFromValues(sb_red.progress, progress, sb_blue.progress))
                updateLabelGreen(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) { }

            override fun onStopTrackingTouch(p0: SeekBar?) { }

        })

        sb_blue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                v_color_result.setBackgroundColor(viewModel.generateColorFromValues(sb_red.progress, sb_green.progress, progress))
                updateLabelBlue(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) { }

            override fun onStopTrackingTouch(p0: SeekBar?) { }

        })

        btn_random_color.setOnClickListener {
            val red = viewModel.generateValueForColor()
            val green = viewModel.generateValueForColor()
            val blue = viewModel.generateValueForColor()

            v_color_result.setBackgroundColor(viewModel.generateColorFromValues(red, green, blue))

            sb_red.progress = red
            sb_green.progress = green
            sb_blue.progress = blue

            updateLabelRed(red)
            updateLabelGreen(green)
            updateLabelBlue(blue)
        }
    }

    private fun updateLabelRed(red: Int) {
        tv_red.text = getString(R.string.tv_bar_red, red)
    }

    private fun updateLabelGreen(green: Int) {
        tv_green.text = getString(R.string.tv_bar_green, green)
    }

    private fun updateLabelBlue(blue: Int) {
        tv_blue.text = getString(R.string.tv_bar_blue, blue)
    }

}
