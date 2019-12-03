package com.mlst.adventofcode.day3

import com.mlst.adventofcode.util.InputReader
import java.io.BufferedInputStream
import java.io.File
import java.io.FileReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.round

object Problem1 {

    fun generatePoints(data: List<String>): Set<Pair<Int, Int>>{
        var x = 0
        var y = 0
        var ans = mutableSetOf<Pair<Int, Int>>()
        var dy = mapOf(
            'U' to 1,
            'D' to -1,
            'L' to 0,
            'R' to 0
        )

        var dx = mapOf(
            'U' to 0,
            'D' to 0,
            'L' to -1,
            'R' to 1
        )
        for(d in data){
            val direction = d[0]
            val amount = d.substring(1).toInt()
            (1..amount).forEach {
                x += dx.getOrElse(direction) { 0 }
                y += dy.getOrElse(direction) { 0 }

                ans.add(x to y)
            }
        }

        return ans.toSet()
    }

    fun compute(paths: MutableList<List<String>>){
        val wire1 = paths.first()
        val wire2 = paths[1]

        println((generatePoints(wire1).intersect(generatePoints(wire2))).map { abs(it.first) + abs(it.second)}.min())
    }
}

fun main(args: Array<String>){
    var paths = mutableListOf<List<String>>()
    InputReader.read("/com/mlst/adventofcode/day3/problem1.input"){
        paths.add(it.split(","))
    }

    Problem1.compute(paths)
}