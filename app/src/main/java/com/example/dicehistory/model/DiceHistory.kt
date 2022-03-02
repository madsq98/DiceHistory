package com.example.dicehistory.model

import java.io.Serializable

class DiceHistory : Serializable {
    var DiceRolls : MutableList<DiceRoll> = mutableListOf()

    fun getAll(): Array<DiceRoll> = DiceRolls.toTypedArray()

    fun getAllAsList(): MutableList<DiceRoll> = DiceRolls

    fun addRoll(roll : DiceRoll) {
        DiceRolls.add(roll)
    }

    fun clear() {
        DiceRolls.clear()
    }
}