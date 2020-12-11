package kiriloman.algorithms.easy

// Problem: https://www.hackerrank.com/challenges/2d-array/problem

fun hourglassSum(array: Array<Array<Int>>): Int {
    val result = Array(16) {0}
    result.forEachIndexed { index, _ ->
        result[index] =
                array[index / 4][index % 4] +
                array[index / 4][index % 4 + 1] +
                array[index / 4][index % 4 + 2] +
                array[index / 4 + 1][index % 4 + 1] +
                array[index / 4 + 2][index % 4] +
                array[index / 4 + 2][index % 4 + 1] +
                array[index / 4 + 2][index % 4 + 2]
    }
    return result.max()!!
}