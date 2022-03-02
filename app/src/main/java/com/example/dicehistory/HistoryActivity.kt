package com.example.dicehistory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.example.dicehistory.model.DiceHistory
import com.example.dicehistory.model.DiceRoll
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    val history : Array<DiceRoll> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        if(intent.extras != null) {
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val adapter = SimpleAdapter(
            this,
            asListMap(DiceHistory().getAll()),
            R.layout.cell,
            arrayOf("hstTimeStamp","hstRoll"),
            intArrayOf(R.id.hstTimeStamp, R.id.roll)
        )

        lvHistory.adapter = adapter
    }

    private fun asListMap(src: Array<DiceRoll>) : List<Map<String,String?>> {
        return src.map { obj -> hashMapOf("hstTimeStamp" to obj.timestamp.toString(), "hstRoll" to obj.toString()) }
    }
}