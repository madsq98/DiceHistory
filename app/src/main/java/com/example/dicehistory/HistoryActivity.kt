package com.example.dicehistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.example.dicehistory.model.DiceHistory
import com.example.dicehistory.model.DiceRoll
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    var historyObj : DiceHistory = DiceHistory()
    override fun onCreate(savedInstanceState: Bundle?) {
        if(intent.extras != null) {
            val b = intent.extras!!
            historyObj = b.getSerializable("history") as DiceHistory
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val adapter = SimpleAdapter(
            this,
            asListMap(historyObj.getAll().reversedArray()),
            R.layout.cell,
            arrayOf("hstTimeStamp","hstRoll"),
            intArrayOf(R.id.hstTimeStamp, R.id.hstRoll)
        )

        lvHistory.adapter = adapter

        backBtn.setOnClickListener {
            val i = Intent()
            val b = Bundle()
            b.putSerializable("historyObj",historyObj)
            i.putExtras(b)
            setResult(RESULT_OK, i)
            finish()
        }

        clearBtn.setOnClickListener {
            historyObj.clear()
            lvHistory.adapter = null
        }
    }

    private fun asListMap(src: Array<DiceRoll>) : List<Map<String,String?>> {
        return src.map { obj -> hashMapOf("hstTimeStamp" to obj.timestamp.toString(), "hstRoll" to obj.toString()) }
    }
}