package kiriloman.algorithms.easy

import javax.xml.stream.events.Characters

/*
    Problem: https://www.hackerrank.com/challenges/find-digits/problem
 */

fun findDigits(n: Int): Int {
    return n.toString().fold(0) { result, digitAsChar ->
        // println(n % Character.getNumericValue(digitAsChar))
        val digit = Character.getNumericValue(digitAsChar)
        if (digit != 0 && n % digit == 0)
            result + 1
        else
            result
    }
}

fun main() {
    println(findDigits(12))
    println(findDigits(1012))
}