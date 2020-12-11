package kiriloman.algorithms.medium

import kotlin.collections.ArrayList

/*
    Problem: https://www.hackerrank.com/challenges/queens-attack-2/problem

    The main idea is to find the closest obstacles to the Queen which are on
    attackable paths. Those obstacles are the only relevant obstacles for the
    final result as they will block any other farther obstacle.
    After, calculate the total number of squares which the Queen could attack
    if no obstacles existed. And, finally, remove from that sum the number
    of squares blocked by each closest obstacle.

    The solution runs in O(k^2)-time due to the removeDistantObstacles method,
    but it can be easily improved to O(k) if we check for the closest obstacles
    and store them in the beginning.

    - n: an integer, the number of rows and columns in the board
    - k: an integer, the number of obstacles on the board
    - r_q: integer, the row number of the queen's position
    - c_q: integer, the column number of the queen's position
    - obstacles: a two dimensional array of integers where each element is an array of
                 integers, the row and column of an obstacle
 */

fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
    val queenPosition = Pair(r_q, c_q)
    val attackableObstaclePairs = obstacles
            .map { array -> Pair(array[0], array[1]) }
            .sortedBy { obstacle -> distance(queenPosition, obstacle) }
            .filter { obstacle -> canAttack(queenPosition, obstacle) }

    val closestObstacles = removeDistantObstacles(attackableObstaclePairs, queenPosition)
    val allAttackableSquares = maxAttackableSquares(n, queenPosition)

    return closestObstacles.fold(allAttackableSquares) { result, obstacle ->
        result - removedSquares(n, queenPosition, obstacle)
    }
}

private fun distance(from: Pair<Int, Int>, to: Pair<Int, Int>): Int {
    return Math.max(Math.abs(from.first - to.first), Math.abs(from.second - to.second))
}

private fun canAttack(queenPosition: Pair<Int, Int>, position: Pair<Int, Int>): Boolean {
    return (Math.abs(queenPosition.first - position.first) == Math.abs(queenPosition.second - position.second) ||
            queenPosition.first == position.first ||
            queenPosition.second == position.second) && queenPosition != position
}

private fun removeDistantObstacles(obstacles: List<Pair<Int, Int>>, queenPosition: Pair<Int, Int>): List<Pair<Int, Int>> {
    val listOfIndexes = ArrayList<Int>()
    obstacles.forEachIndexed { index1, obstacle1 ->
        obstacles.subList(index1 + 1, obstacles.size).forEachIndexed { index2, obstacle2 ->
            if (sameDirection(queenPosition, obstacle1, obstacle2))
                listOfIndexes.add(index2 + index1 + 1)
        }
    }
    listOfIndexes.sort()
    return obstacles.removeAll(listOfIndexes.distinct())
}

private fun sameDirection(queenPosition: Pair<Int, Int>, position1: Pair<Int, Int>, position2: Pair<Int, Int>): Boolean {
    val diff1 = Pair(queenPosition.first - position1.first, queenPosition.second - position1.second)
    val diff2 = Pair(queenPosition.first - position2.first, queenPosition.second - position2.second)

    return (queenPosition.first == position1.first && queenPosition.first == position2.first && diff1.second * diff2.second > 0) ||
            (queenPosition.second == position1.second && queenPosition.second == position2.second && diff1.first * diff2.first > 0) ||
            (diff1.first * diff2.first > 0 && diff1.second * diff2.second > 0)
}

private fun maxAttackableSquares(dimension: Int, queenPosition: Pair<Int, Int>): Int {
    return minDistance(queenPosition, Pair(1, 1)) +
            minDistance(queenPosition, Pair(dimension, 1)) +
            minDistance(queenPosition, Pair(dimension, dimension)) +
            minDistance(queenPosition, Pair(1, dimension)) +
            dimension - queenPosition.first +
            queenPosition.second - 1 +
            queenPosition.first - 1 +
            dimension - queenPosition.second
}

private fun minDistance(from: Pair<Int, Int>, to: Pair<Int, Int>): Int {
    return Math.min(Math.abs(from.first - to.first), Math.abs(from.second - to.second))
}

private fun removedSquares(dimension: Int, queenPosition: Pair<Int, Int>, position: Pair<Int, Int>): Int {
    val diff1 = queenPosition.first - position.first
    val diff2 = queenPosition.second - position.second

    if (diff1 > 0 && diff2 > 0)
        return minDistance(position, Pair(1, 1)) + 1
    if (diff1 > 0 && diff2 < 0)
        return minDistance(position, Pair(1, dimension)) + 1
    if (diff1 < 0 && diff2 < 0)
        return minDistance(position, Pair(dimension, dimension)) + 1
    if (diff1 < 0 && diff2 > 0)
        return minDistance(position, Pair(dimension, 1)) + 1
    if (diff1 < 0)
        return dimension - position.first + 1
    if (diff1 > 0)
        return position.first
    if (diff2 < 0)
        return dimension - position.second + 1
    if (diff2 > 0)
        return position.second
    return 0
}

private fun List<Pair<Int, Int>>.removeAll(indexes: List<Int>): List<Pair<Int, Int>> {
    val mutableList = this.toMutableList()
    for (i in indexes.asReversed()) {
        mutableList.removeAt(i)
    }
    return mutableList
}
