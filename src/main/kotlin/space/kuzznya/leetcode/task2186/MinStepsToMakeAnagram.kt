package space.kuzznya.leetcode.task2186

class Solution {
    fun minSteps(s: String, t: String): Int {
        val mapT = mutableMapOf<Char, Int>()
        for (c in t) {
            mapT[c] = 1 + (mapT[c] ?: 0)
        }

        var diff = 0

        for (c in s) {
            val count = getAndDecrement(mapT, c)
            if (count == 0) diff++
        }
        diff += mapT.values.sum()
        return diff
    }

    private fun getAndDecrement(m: MutableMap<Char, Int>, c: Char): Int {
        val count = m[c] ?: return 0
        if (count == 1) {
            m.remove(c)
            return count
        }
        m[c] = count - 1
        return count
    }
}
