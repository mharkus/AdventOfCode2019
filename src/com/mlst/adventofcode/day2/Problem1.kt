package com.mlst.adventofcode.day2

import com.mlst.adventofcode.util.InputReader
import kotlin.math.round

object Problem1 {
    fun compute(code: MutableList<Int>){
        var ctr = 0
        code[1] = 12
        code[2] = 2
        loop@ while(ctr < code.size){
            val opcode = code[ctr++]
            val n1Index = code[ctr++]
            val n2Index = code[ctr++]
            val outputIndex = code[ctr++]

            println(opcode)
            code[outputIndex] = when (opcode) {
                1 -> code[n1Index] + code[n2Index]
                2 -> code[n1Index] * code[n2Index]
                else -> break@loop
            }
        }

        println(code.joinToString(","))
    }
}

fun main(args: Array<String>){
    InputReader.read("/com/mlst/adventofcode/day2/problem1.input"){
        println(Problem1.compute(it.split(",").map { it.toInt() }.toMutableList()))
    }
}