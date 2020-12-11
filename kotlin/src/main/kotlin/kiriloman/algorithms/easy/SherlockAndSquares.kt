package kiriloman.algorithms.easy

import kotlin.math.sqrt

/*
    Problem: https://www.hackerrank.com/challenges/sherlock-and-squares/problem
 */

fun squares(a: Int, b: Int): Int {
    var numOfSquares = 0
    val initialRange = a..b

    for (num in sqrt(a.toDouble()).toInt()..sqrt(b.toDouble()).toInt()) {
        if (num * num in initialRange) {
            numOfSquares++
        }
    }

    return numOfSquares
}

fun main() {
    println(squares(3, 9)) // 2
    println(squares(17, 24)) // 0
}