package space.kuzznya.leetcode.task8

class Solution {

    companion object {
        @JvmStatic
        fun isDigit(c: Char) = c in '0'..'9'

        @JvmStatic
        fun toDigit(c: Char) = c - '0'
    }

    fun myAtoi(s: String): Int {
        var pos = 0

        while (pos != s.length && s[pos] == ' ') pos++
        if (pos == s.length) return 0

        var sign = 1
        if (s[pos] == '+') {
            pos++
        } else if (s[pos] == '-') {
            sign = -1
            pos++
        }

        var result = 0
        while(pos != s.length && isDigit(s[pos])) {
            val t = result
            result *= 10
            if (result / 10 != t) return if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE
            result += toDigit(s[pos])
            if (result < 0) return if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE
            pos++
        }
        return sign * result
    }
}

