package space.kuzznya.leetcode.task1653

class Solution {
    fun minimumDeletions(s: String): Int {
        var leftBCount = 0
        val leftB = IntArray(s.length) { i -> if (s[i] == 'b') leftBCount++ else leftBCount }
        var rightACount = 0
        val rightA = IntArray(s.length)
        for (i in s.length - 1 downTo 0) {
            rightA[i] = if (s[i] == 'a') rightACount++ else rightACount
        }
        var min = leftB[0] + rightA[0]
        for (i in s.indices) {
            if (leftB[i] + rightA[i] < min)
                min = leftB[i] + rightA[i]
        }
        return min
    }
}
