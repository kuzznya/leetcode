package space.kuzznya.leetcode.task13

class Solution {
    fun romanToInt(s: String): Int {
        var value = 0
        var prev: Char? = null
        for (cur in s) {
            if (prev != null) {
                if (isValidCombination(prev, cur)) {
                    println("Adding " + (values[cur]!! - values[prev]!!))
                    value += values[cur]!! - values[prev]!!
                    prev = null
                    continue
                }
                println("Adding " + values[prev]!!)
                value += values[prev]!!
            }
            prev = cur
        }
        if (prev != null) value += values[prev]!!
        return value
    }
}

val values = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

fun isValidCombination(first: Char, second: Char): Boolean = when (first) {
    'I' -> second == 'V' || second == 'X'
    'X' -> second == 'L' || second == 'C'
    'C' -> second == 'D' || second == 'M'
    else -> false
}
