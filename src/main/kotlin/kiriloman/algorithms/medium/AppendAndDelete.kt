package kiriloman.algorithms.medium

/* Problem: https://www.hackerrank.com/challenges/append-and-delete/problem

 */

fun appendAndDelete(s: String, t: String, k: Int): String {
    val lengthDifference = Math.abs(s.length - t.length)
    val leastLength = Math.min(s.length, t.length)

    if (k >= leastLength * 2 + lengthDifference) return "Yes"

    for (i in 0 until leastLength - 1) {
        if (s[i] != t[i]) {
            return when {
                (k >= (leastLength - i) * 2 + lengthDifference) && (k - (leastLength - i) * 2 - lengthDifference) % 2 == 0 -> "Yes"
                else -> "No"
            }
        }
    }

    return when {
        (k % 2 == 0 || k >= leastLength) && lengthDifference == 0 -> "Yes"
        lengthDifference <= k && (k - lengthDifference) % 2 == 0 -> "Yes"
        else -> "No"
    }
}

fun main(args: Array<String>) {
    val s = "hackerhappy"
    val t = "hackerrank"
    val k = 9

    println(appendAndDelete(s, t, k))
}