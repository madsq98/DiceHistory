package com.example.dicehistory.model

import java.time.LocalDateTime
import java.io.Serializable

data class DiceRoll(var timestamp: LocalDateTime, var rolledEyes: Array<Int>) : Serializable {
    override fun toString(): String {
        return rolledEyes.joinToString(" - ")
    }
}
