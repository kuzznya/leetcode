package space.kuzznya.leetcode.task2194

fun Char.digitToInt() = this - '0'

fun Char.letterToInt() = this - 'A'

fun Int.intToLetter() = (this + 'A'.toInt()).toChar()

class Solution {
    fun cellsInRange(s: String): List<String> {
        val splitted = s.split(':')
        val start = splitted[0]
        val end = splitted[1]
        val startCol = start[0].letterToInt()
        val startRow = start[1].digitToInt()
        val endCol = end[0].letterToInt()
        val endRow = end[1].digitToInt()

        val result = mutableListOf<String>()
        for (i in startCol..endCol) {
            for (j in startRow..endRow) {
                result += i.intToLetter().toString() + j
            }
        }
        return result
    }
}
