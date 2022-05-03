package space.kuzznya.leetcode.task10

class Solution {

    fun isMatch(str: String, pattern: String): Boolean {
        return match(str, pattern, 0, 0)
    }

    tailrec fun match(str: String, pattern: String, sPos: Int, pPos: Int): Boolean {
        if (sPos == str.length && pPos < pattern.length) {
            if (pPos == pattern.length - 1) return pattern[pPos] == '*'
            var pPosEnd = if (pattern[pPos] == '*') pPos + 1 else pPos
            while (pPosEnd <= pattern.length - 2) {
                if (pattern[pPosEnd + 1] != '*') return false
                pPosEnd += 2
            }
            return pPosEnd == pattern.length
        }
        if (sPos == str.length && pPos == pattern.length) return true
        if (sPos == str.length || pPos == pattern.length) return false

        return if (pattern[pPos] == '*') {
            if ((str[sPos] == pattern[pPos - 1] || pattern[pPos - 1] == '.') &&
                match(str, pattern, sPos + 1, pPos)) true
            else match(str, pattern, sPos, pPos + 1)
        } else if (pPos + 1 < pattern.length && pattern[pPos + 1] == '*') {
            match(str, pattern, sPos, pPos + 1)
        } else {
            if (!(str[sPos] == pattern[pPos] || pattern[pPos] == '.')) false
            else match(str, pattern, sPos + 1, pPos + 1)
        }
    }
}
