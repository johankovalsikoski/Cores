package johan.kovalsikoski.cores

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val context: Context, private val colorList: List<ColorObject>): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_historic, parent, false))

    override fun getItemCount(): Int = colorList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(colorList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(colorObject: ColorObject) {

            val tvRed = itemView.findViewById<TextView>(R.id.tv_red)
            val tvGreen = itemView.findViewById<TextView>(R.id.tv_green)
            val tvBlue = itemView.findViewById<TextView>(R.id.tv_blue)
            val vResult = itemView.findViewById<View>(R.id.v_color_result)

            tvRed.text = "Vermelho: ${colorObject.red}"
            tvGreen.text = "Verde: ${colorObject.green}"
            tvBlue.text = "Azul: ${colorObject.blue}"

            vResult.setBackgroundColor(Color.rgb(colorObject.red, colorObject.green, colorObject.blue))

        }
    }

}