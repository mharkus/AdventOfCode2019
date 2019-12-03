package com.mlst.adventofcode.day3

import com.mlst.adventofcode.util.InputReader

object Problem2 {

    private fun generatePoints(data: List<String>): Map<Pair<Int, Int>, Int>{
        var x = 0
        var y = 0
        var ans = mutableMapOf<Pair<Int, Int>, Int>()
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
        var len = 0
        for(d in data){
            val direction = d[0]
            val amount = d.substring(1).toInt()

            (1..amount).forEach {
                x += dx.getOrElse(direction) { 0 }
                y += dy.getOrElse(direction) { 0 }
                len++
                if(x to y !in ans) ans[x to y] = len
            }
        }

        return ans.toMap()
    }

    fun compute(paths: MutableList<List<String>>){
        val wire1 = paths.first()
        val wire2 = paths[1]

        val p1 = generatePoints(wire1)
        val p2 = generatePoints(wire2)
        val p = p1.keys.intersect(p2.keys)
        println(p.map { p1.getOrElse(it) { 0 } + p2.getOrElse(it) { 0 }}.min())

    }
}

fun main() {
    var paths = mutableListOf<List<String>>()
    InputReader.read("/com/mlst/adventofcode/day3/problem1.input"){
        paths.add(it.split(","))
    }

    Problem2.compute(paths)
}