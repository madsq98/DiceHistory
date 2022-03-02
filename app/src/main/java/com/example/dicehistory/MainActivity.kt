package com.example.dicehistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.dicehistory.model.DiceHistory
import com.example.dicehistory.model.DiceRoll
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val randomGenerator = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.dice_array,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDices.adapter = adapter

        historyBtn.setOnClickListener {
            var i = Intent(this, HistoryActivity::class.java)
            startActivity(i)
        };

        roll.setOnClickListener {
            doRoll(spinnerDices.selectedItem.toString().toInt())
        }
    }

    fun doRoll(amtDices : Int) {
        val rolls : ArrayList<Int> = arrayListOf()

        for(i in 1..amtDices) {
            rolls.add((randomGenerator.nextInt(6) + 1))
        }

        val rollObj = DiceRoll(LocalDateTime.now(), rolls.toTypedArray())

        DiceHistory().addRoll(rollObj)

        println("History size: " + DiceHistory().getAllAsList().size)

        txtResult.setText(rollObj.toString())
    }
}