package kiriloman.algorithms.medium

import java.util.ArrayDeque

/*  Problem: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

    The following algorithm runs in O(m + n) time where n is the number of different scores provided
    and m is the number of Alice's scores.
    It uses a stack with the lowest scores on the top and highest on the bottom.
 */

fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
    val scoreStack = ArrayDeque<Int>()
    scoreStack.addAll(scores.distinct().reversed())

    return alice.foldIndexed(Pair(IntArray(alice.size), scoreStack.size + 1)) { index, pair, points ->
        var rankUps = 0

        while (scoreStack.peek() != null && scoreStack.peek() <= points) {
            scoreStack.pop()
            rankUps++
        }

        pair.first[index] = pair.second - rankUps
        pair.copy(second = pair.second - rankUps)
    }.first.toTypedArray()
}


fun main(args: Array<String>) {
    val scores = arrayOf(100, 100, 50, 40, 40, 20, 10)
    val alice = arrayOf(5, 25, 50, 120)

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}
