package kiriloman.algorithms.easy

/*
    Problem: https://www.hackerrank.com/challenges/time-conversion/problem
 */

fun timeConversion(s: String): String {
    val partOfDay = s.takeLast(2)
    val hours = s.take(2)

    return when (partOfDay) {
        "AM" -> if (hours.toInt() % 12 < 10)
            "0${hours.toInt() % 12}${s.substring(2, 8)}"
        else
            "${hours.toInt() % 12}${s.substring(2, 8)}"
        else -> "${hours.toInt() % 12 + 12}${s.substring(2, 8)}"
    }
}
