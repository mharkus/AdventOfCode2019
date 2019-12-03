package com.mlst.adventofcode.day2

import com.mlst.adventofcode.util.InputReader

object Problem2 {
    fun compute(x: Int, y: Int, code: MutableList<Int>): Boolean{
        var ctr = 0
        code[1] = x
        code[2] = y
        loop@ while(ctr < code.size){
            val opcode = code[ctr++]
            val n1Index = code[ctr++]
            val n2Index = code[ctr++]
            val outputIndex = code[ctr++]
            code[outputIndex] = when (opcode) {
                1 -> code[n1Index] + code[n2Index]
                2 -> code[n1Index] * code[n2Index]
                else -> break@loop
            }
        }

        return code.first() == 19690720
    }
}

fun main(args: Array<String>){
    InputReader.read("/com/mlst/adventofcode/day2/problem1.input"){
        for(x in 0..99){
            for(y in 0..99){
                if(Problem2.compute(x,y, it.split(",").map { it.toInt() }.toMutableList())){
                    println("${100 * x + y}")
                    break
                }
            }
        }
    }
}