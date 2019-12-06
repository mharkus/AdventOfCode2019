package com.mlst.adventofcode.day6

import com.mlst.adventofcode.util.InputReader

object Problem2 {

    private val map = mutableMapOf<String, String>()

    fun addNode(input: String) {
        val parts = input.split(")")
        if (parts[1] !in map) map[parts[1]] = parts[0]
    }

    private fun getParents(node: String): List<String> {
        var output = mutableListOf<String>()
        var parent = map[node]
        while (parent != null) {
            output.add(parent)
            parent = map[parent]
        }

        return output.toList()
    }

    fun transfer(): Int {
        val youParents = getParents("YOU")
        val santaParents = getParents("SAN")
        
        return (youParents.union(santaParents) -
                youParents.intersect(santaParents))
            .size
    }
}

fun main() {
    InputReader.read("/com/mlst/adventofcode/day6/problem1.input") {
        Problem2.addNode(it)
    }

    println(Problem2.transfer())
}

