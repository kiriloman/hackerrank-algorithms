package kiriloman.algorithms.easy

/*
    Problem: https://www.hackerrank.com/challenges/mini-max-sum/problem
 */

fun miniMaxSum(arr: Array<Int>) {
    arr.sort()
    val longArray = arr.map { value -> value.toLong() }
    print("${longArray.take(4).sum()} ${longArray.takeLast(4).sum()}")
}
