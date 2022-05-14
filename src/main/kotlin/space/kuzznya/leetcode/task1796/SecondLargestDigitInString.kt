package space.kuzznya.leetcode.task1796

// polyfill for Kotlin 1.3
fun Char.digitToInt(): Int = this.code - '0'.code // this.toInt() - '0'.toInt() for Kotlin 1.3

class Solution {
    fun secondHighest(s: String): Int {
        var max1: Char? = null
        var max2: Char? = null
        for (c in s) {
            if (!c.isDigit())
                continue
            if (max1 == null || max1 < c) {
                max2 = max1
                max1 = c
            }
            else if (c != max1 && (max2 == null || max2 < c)) {
                max2 = c
            }
        }
        return max2?.digitToInt() ?: -1
    }
}
