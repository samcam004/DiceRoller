package com.samcam.project4.ui.main

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class RollViewModel : ViewModel() {

    fun getStats(diceType : Int, numDice : Int, rollMod : Int) : ArrayList<Double> {
        val rolls : ArrayList<Int> = ArrayList()
        val sendBack : ArrayList<Double> = ArrayList()
        var count = numDice
        var setRand = diceType + 1
        var sum = 0.0
        var low = 0.0
        var high = 0.0
        var average = 0.0

        for (i  in 1..count) {
            rolls.add(Random.nextInt(1, setRand) + rollMod)
        }

        for (i in 0 until count) {
            sum += rolls.get(i).toDouble()
        }

        low = rolls.min().toDouble()
        high = rolls.max().toDouble()
        average = sum.toDouble() / count.toDouble()

        sendBack.add(sum)
        sendBack.add(low)
        sendBack.add(high)
        sendBack.add(average)

        return sendBack
    }

    fun getBigSum(d4Sum : Int, d6Sum : Int, d8Sum : Int, d10Sum : Int, d12Sum : Int, d20Sum : Int ) : Int{
        var bigSum = d4Sum + d6Sum + d8Sum + d10Sum + d12Sum + d20Sum
        return bigSum
    }

}