package com.mlst.adventofcode.day4

import com.mlst.adventofcode.util.InputReader

object Problem2 {
    fun compute(from: Int, to: Int): Int {
        return (from..to).filter {
            it.toString().map { it.toString().toInt() } == it.toString().map { it.toString().toInt() }.sorted()
        }
            .filter { it.toString().groupBy { it }.values.any { it.size == 2 } }
            .count()
    }
}

fun main() {
    InputReader.read("/com/mlst/adventofcode/day4/problem1.input") {
        val values = it.split("-").map { it.toInt() }
        println(Problem2.compute(values[0], values[1]))
    }

}