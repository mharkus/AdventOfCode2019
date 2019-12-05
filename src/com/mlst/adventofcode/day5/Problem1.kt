package com.mlst.adventofcode.day5

import com.mlst.adventofcode.util.InputReader

object Problem1 {
    fun compute(code: MutableList<Int>) {
        var ctr = 0
        loop@ while (ctr < code.size) {
            val instruction = code[ctr].toString()
            val modes = IntArray(3)

            var opcode =
                if (instruction.length == 1) instruction.toInt() else instruction.substring(instruction.length - 2).toInt()

            if (instruction.length > 2) modes[0] = Character.getNumericValue(instruction[instruction.length - 3])
            if (instruction.length > 3) modes[1] = Character.getNumericValue(instruction[instruction.length - 4])
            if (instruction.length > 4) modes[2] = Character.getNumericValue(instruction[0])

            when (opcode) {
                1 -> {
                    if (modes[2] == 1) code[ctr + 3] else code[code[ctr + 3]] =
                        (if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]]) + (if (modes[1] == 1) code[ctr + 2] else code[code[ctr + 2]])
                    ctr += 4
                }
                2 -> {
                    if (modes[2] == 1) code[ctr + 3] else code[code[ctr + 3]] =
                        (if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]]) * (if (modes[1] == 1) code[ctr + 2] else code[code[ctr + 2]])
                    ctr += 4
                }
                3 -> {
                    if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]] = 5
                    ctr += 2
                }
                4 -> {
                    println(if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]])
                    ctr += 2
                }
                5 -> {
                    if ((if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]]) != 0) ctr =
                        if (modes[1] == 1) code[ctr + 2] else code[code[ctr + 2]] else ctr += 3
                }
                6 -> {
                    if ((if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]]) == 0) ctr =
                        if (modes[1] == 1) code[ctr + 2] else code[code[ctr + 2]] else ctr += 3
                }
                7 -> {
                    if (modes[2] == 1) code[ctr + 3] else code[code[ctr + 3]] =
                        if ((if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]]) <
                            (if (modes[1] == 1) code[ctr + 2] else code[code[ctr + 2]])
                        ) 1 else 0
                    ctr += 4
                }
                8 -> {
                    if (modes[2] == 1) code[ctr + 3] else code[code[ctr + 3]] =
                        if ((if (modes[0] == 1) code[ctr + 1] else code[code[ctr + 1]]) ==
                            (if (modes[1] == 1) code[ctr + 2] else code[code[ctr + 2]])
                        ) 1 else 0

                    ctr += 4
                }
                else -> break@loop

            }
        }
    }
}

fun main(args: Array<String>) {
    InputReader.read("/com/mlst/adventofcode/day5/problem1.input") {
        println(Problem1.compute(it.split(",").map { it.toInt() }.toMutableList()))
    }
}