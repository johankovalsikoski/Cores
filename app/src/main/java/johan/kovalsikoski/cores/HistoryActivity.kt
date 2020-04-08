package johan.kovalsikoski.cores

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    private lateinit var database: Database
    //private Database database;

    private lateinit var historyAdapter: HistoryAdapter
    //private HistoryAdapter historyAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val sharedPreferences: SharedPreferences = getSharedPreferences("cores", Context.MODE_PRIVATE)
        //SharedPreferences sharedPreferences = getSharedPreferences("cores", Context.MODE_PRIVATE);

        val jsonString = sharedPreferences.getString("database", "")
        //String jsonString = sharedPreferences.getstring("database", "");

        database = Gson().fromJson(jsonString, Database::class.java)
        //database = new Gson().fromJson(jsonString, Database.class);

        historyAdapter = HistoryAdapter(this, database.colorList)
        //historyAdapter = new HistoryAdapter(this, database.getColorList());

        rv_colors.adapter = historyAdapter
        /*
        * RecyclerView rvColors = findViewById(R.id.rv_colors);
        * rvColors.setAdapter(historyAdapter);
        */
    }
}
