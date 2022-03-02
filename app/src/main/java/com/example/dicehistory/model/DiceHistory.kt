package com.example.dicehistory.model

import java.io.Serializable

class DiceHistory : Serializable {
    val DiceRolls : ArrayList<DiceRoll> = arrayListOf<DiceRoll>()

    fun getAll(): Array<DiceRoll> = DiceRolls.toTypedArray()

    fun getAllAsList(): ArrayList<DiceRoll> = DiceRolls

    fun addRoll(roll : DiceRoll) {
        DiceRolls.add(roll)
    }

    fun clear() {
        DiceRolls.clear()
    }
}