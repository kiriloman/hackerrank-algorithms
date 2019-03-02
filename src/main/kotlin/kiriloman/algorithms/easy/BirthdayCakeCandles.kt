package kiriloman.algorithms.easy

/*
    Problem: https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */

fun birthdayCakeCandles(ar: Array<Int>): Int {
    val maxHeight = ar.max()
    return ar.count { it == maxHeight }
}