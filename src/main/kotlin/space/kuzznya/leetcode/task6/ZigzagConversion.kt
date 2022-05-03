package space.kuzznya.leetcode.task6

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val result = CharArray(s.length)

        val sums = IntArray(numRows)
        sums[0] = charsInRow(s.length, numRows, 0)
        for (i in 1 until sums.size)
            sums[i] = sums[i - 1] + charsInRow(s.length, numRows, i)

        var row = 0
        var down = true // true -> going down, false -> going up
        val countInRow = IntArray(numRows) { 0 }

        for (i in s.indices) {
            val prevRow = row - 1
            val charsBefore = if (prevRow >= 0) sums[prevRow] else 0
            val pos = charsBefore + countInRow[row]
            result[pos] = s[i]
            countInRow[row]++

            if (down) {
                row++
                if (row == numRows) {
                    down = false
                    row -= 2
                }
            } else {
                row--
                if (row == -1) {
                    down = true
                    row += 2
                }
            }
        }

        return String(result)
    }

    fun charsInRow(len: Int, numRows: Int, row: Int): Int {
        if (row == len - 1) return 1
        if (row >= len) return 0

        if (row == 0) return (len - 1) / (numRows - 1) / 2 + 1
        if (row == numRows - 1) return (len - (numRows - 1) - 1) / (numRows - 1) / 2 + 1

        val mainCount = (len - 1) / (numRows - 1)
        val additional = if (mainCount % 2 == 0 /* if last part going down */) {
            if (row <= (len - 1) % (numRows - 1)) 1 else 0
        } else { // if last part is going up
            if (row >= (numRows - 1) - (len - 1) % (numRows - 1)) 1 else 0
        }
        return mainCount + additional
    }
}
