package com.example.dicehistory.model

import java.io.Serializable

class DiceHistory : Serializable {
    val DiceRolls = arrayListOf<DiceRoll>()

    fun getAll(): ArrayList<DiceRoll> = DiceRolls

    fun addRoll(roll : DiceRoll) {
        DiceRolls.add(roll)
    }
}