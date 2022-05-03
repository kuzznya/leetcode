package space.kuzznya.leetcode.task5

/**
 * Naive solution, too long
 */
class Solution {
    fun longestPalindrome(s: String): String {
        var maxStart = 0
        var maxEnd = 0
        for (start in 0..s.length) {
            if (s.length - start < maxEnd - maxStart)
                break
            for (end in s.length downTo start) {
                if (end - start <= maxEnd - maxStart) break
                if (isPalindrome(s, start, end) && end - start > maxEnd - maxStart) {
                    maxStart = start
                    maxEnd = end
                    break
                }
            }
        }
        return s.substring(maxStart, maxEnd)
    }

    fun isPalindrome(s: String, start: Int, end: Int): Boolean =
        if (start == end) true
        else (0 .. (end - start) / 2).all { i -> s[start + i] == s[end - i - 1] }
}

// this is a good one
class Solution2 {
    fun longestPalindrome(s: String): String {
        var maxStart = 0
        var maxEnd = 0
        for (pos in s.indices) {
            val oddPalindrome = findOddLenPalindrome(s, pos)
            var start = oddPalindrome.first
            var end = oddPalindrome.second
            if (end - start > maxEnd - maxStart) {
                maxStart = start
                maxEnd = end
            }

            val evenPalindrome = findEvenLenPalindrome(s, pos)
            start = evenPalindrome.first
            end = evenPalindrome.second
            if (end - start > maxEnd - maxStart) {
                maxStart = start
                maxEnd = end
            }
        }

        return s.substring(maxStart, maxEnd)
    }

    private fun findOddLenPalindrome(s: String, pos: Int): Pair<Int, Int> {
        if (pos == s.length - 1) return pos to pos + 1
        var offset = 1
        while (pos - offset >= 0 && pos + offset < s.length && s[pos - offset] == s[pos + offset]) {
            offset++
        }
        return pos - offset + 1 to pos + offset
    }

    private fun findEvenLenPalindrome(s: String, pos: Int): Pair<Int, Int> {
        if (pos + 1 >= s.length || s[pos] != s[pos + 1]) return pos to pos + 1
        var offset = 1
        while (pos - offset >= 0 && pos + offset + 1 < s.length && s[pos - offset] == s[pos + offset + 1]) {
            offset++
        }
        return pos - offset + 1 to pos + offset + 1
    }
}
