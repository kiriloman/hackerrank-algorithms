package kiriloman.algorithms.easy

/*
    Problem: https://www.hackerrank.com/challenges/save-the-prisoner/problem
 */

fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
    val lastPosition = (s + m - 1) % n
    return if (lastPosition == 0)
        n
    else
        lastPosition
}