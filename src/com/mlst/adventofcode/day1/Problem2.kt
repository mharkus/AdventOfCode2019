package com.mlst.adventofcode.day1

import com.mlst.adventofcode.util.InputReader
import kotlin.math.round

object Problem2 {
    fun getTotalFuel(mass: Int, total: Int): Int{
        val fuel = round((mass/3).toDouble()).toInt() - 2
        if(fuel <= 0) return total

        return getTotalFuel(fuel, total + fuel)
    }
}

fun main(args: Array<String>){
    var ctr = 0
    InputReader.read("/com/mlst/adventofcode/day1/problem2.input"){
        ctr += Problem2.getTotalFuel(Integer.parseInt(it), 0)
    }

    println(ctr)
}

