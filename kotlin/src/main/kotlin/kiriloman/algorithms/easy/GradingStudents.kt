package kiriloman.algorithms.easy

/*
    Problem: https://www.hackerrank.com/challenges/grading/problem
 */

fun gradingStudents(grades: Array<Int>): Array<Int> {
    return grades.map { grade ->
        if (grade < 38)
            grade
        else
            roundGrade(grade)
    }.toTypedArray()
}

fun roundGrade(grade: Int): Int {
    val rest = grade % 5
    return if (rest > 2)
        grade + 5 - rest
    else
        grade
}
