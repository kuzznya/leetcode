package space.kuzznya.leetcode.task3

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        var maxLen = 0
        val chars = mutableSetOf<Char>()

        while (end != s.length) {
            if (!chars.contains(s[end])) {
                chars += s[end]
                end++
                if (end - start > maxLen) maxLen = end - start
            } else {
                chars -= s[start]
                start++
            }
        }
        return maxLen
    }
}
