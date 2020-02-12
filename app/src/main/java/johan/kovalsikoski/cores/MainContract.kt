package johan.kovalsikoski.cores

interface MainContract {

    interface View {
        fun updateLabelRed(red: Int)
        fun updateLabelGreen(green: Int)
        fun updateLabelBlue(blue: Int)
    }

    interface Presenter {
        fun generateValueForColor(): Int
        fun generateColorFromValues(red: Int, green: Int, blue: Int): Int
    }

}