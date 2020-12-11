package kiriloman.algorithms.easy

import java.util.Stack
import java.util.EmptyStackException

fun countingValleys(n: Int, s: String): Int {
    val stack = Stack<Char>()
    var result = 0

    for (char in s) {
        val headOfStack = stack.peekOrNull()
        if (headOfStack == 'D' && char == 'U' || headOfStack == 'U' && char == 'D') {
            stack.pop()
            continue
        }
        if (headOfStack == null && char == 'D')
            result++
        stack.push(char)
    }

    return result
}

private fun Stack<out Any>.peekOrNull(): Any? {
    return try {
        this.peek()
    } catch (exception: EmptyStackException) {
        null
    }
}
