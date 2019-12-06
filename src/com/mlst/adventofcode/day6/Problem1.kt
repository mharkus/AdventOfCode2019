package com.mlst.adventofcode.day6

import com.mlst.adventofcode.util.InputReader

object Problem1 {

    private val map = mutableMapOf<String, String>()

    fun addNode(input: String) {
        val parts = input.split(")")
        if(parts[1] !in map) map[parts[1]] = parts[0]
    }

    fun count(): Int {
        val temp = mutableMapOf<String, Int>()

        map.forEach {
            if(it.value !in map) temp[it.key] = 1
            else {
                var parent: String? = it.value
                var ctr = 0
                while(parent != null){
                    ctr++
                    parent = map[parent]
                }

                temp[it.key] = ctr
            }

        }

        return temp.values.sum()
    }
}

fun main() {
    InputReader.read("/com/mlst/adventofcode/day6/problem1.input") {
        Problem1.addNode(it)
    }

    println(Problem1.count())
}

