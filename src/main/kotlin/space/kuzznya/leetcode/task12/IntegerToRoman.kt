package space.kuzznya.leetcode.task12

class Solution {

    companion object {
        val v = listOf(
            1 to 'I',
            5 to 'V',
            10 to 'X',
            50 to 'L',
            100 to 'C',
            500 to 'D',
            1000 to 'M'
        )

        val validDecrementingValues = mapOf(
            'V' to 0,
            'X' to 0,
            'L' to 2,
            'C' to 2,
            'D' to 4,
            'M' to 4
        )
    }

    fun intToRoman(num: Int): String {
        var n = num
        var currentPos = v.size - 1
        val result = StringBuilder()
        while (n > 0) {
            val cur = v[currentPos]
            val count = n / cur.first
            result.append(cur.second.toString().repeat(count))
            n %= cur.first
            val minusPos = validDecrementingValues[cur.second]
            if (minusPos != null && cur.first - v[minusPos].first <= n) {
                result.append(v[minusPos].second)
                result.append(cur.second)
                n -= cur.first - v[minusPos].first
            }
            currentPos -= 1
        }
        return result.toString()
    }
}
