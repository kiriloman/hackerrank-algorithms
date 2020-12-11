package kiriloman.algorithms.medium

import java.math.BigInteger

/* Problem: https://www.hackerrank.com/challenges/extra-long-factorials/problem
   A straightforward factorial implementation.
 */

fun extraLongFactorials(n: Int) {
    var result = BigInteger.valueOf(1)
    for (i in n.toLong() downTo 1) {
        result = result.times(BigInteger.valueOf(i))
    }
    println(result)
}

fun main(args: Array<String>) {
    val n = 10000
    extraLongFactorials(n)

    val m = 100000
    extraLongFactorials(m)
}