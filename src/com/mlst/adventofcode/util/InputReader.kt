package com.mlst.adventofcode.util

import com.mlst.adventofcode.day1.Problem1
import java.io.BufferedInputStream
import java.io.InputStreamReader

object InputReader {
    fun read(file: String, func: (String)->Unit ){
        InputStreamReader(BufferedInputStream(Problem1.javaClass.getResourceAsStream(file))).forEachLine {
            func.invoke(it)
        }
    }
}