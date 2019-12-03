package com.mlst.adventofcode.day1

import com.mlst.adventofcode.util.InputReader
import java.io.BufferedInputStream
import java.io.File
import java.io.FileReader
import java.io.InputStreamReader
import kotlin.math.round

object Problem1 {
    fun getTotalFuel(mass: Int): Int{
        return round((mass/3).toDouble()).toInt() - 2
    }
}

fun main(args: Array<String>){
    var ctr = 0
    InputReader.read("/com/mlst/adventofcode/day1/problem1.input"){
        ctr += Problem1.getTotalFuel(Integer.parseInt(it))
    }

    println(ctr)
}