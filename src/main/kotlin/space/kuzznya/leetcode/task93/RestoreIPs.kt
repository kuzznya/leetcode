package space.kuzznya.leetcode.task93

// polyfill for Kotlin 1.3
fun Char.digitToInt(): Int = this.code - '0'.code // this.toInt() - '0'.toInt() for Kotlin 1.3

class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()
        getIPs(s, ".", 0, 0, 0, result)
        return result
    }

    tailrec fun getIPs(s: String, prefix: String, pos: Int, lastByte: Int, lastByteLen: Int, result: MutableList<String>) {
        if (pos == s.length) {
            if (prefix.count { it == '.' } == 4 && lastByte <= 255)
                result.add(prefix.substring(1))
            return
        }

        if (lastByteLen == 3) {
            if (prefix[prefix.length - 4] != '.') return // in case if current last byte is too long
            if (lastByte <= 255)
                return getIPs(s, prefix + '.', pos, 0, 0 , result) // when last byte is correct
            else
                return // when last byte is too big
        }

        // if (prefix.length >= 2 && prefix[prefix.length - 2] == '.' && prefix[prefix.length - 1] == '0')
        if (lastByteLen == 1 && lastByte == 0)
            return getIPs(s, prefix + '.', pos, 0, 0, result) // when end of the prefix is '.0' - we should just make it '.0.' and go further
        // if (prefix.length >= 1 && prefix[prefix.length - 1] == '.')
        if (lastByteLen == 0)
            return getIPs(s, prefix + s[pos], pos + 1, s[pos].digitToInt(), lastByteLen + 1, result) // when pattern ends with . - just going further in input string

        // if (prefix.length >= 3 && prefix[prefix.length - 3] == '.')
        if (lastByteLen == 2) {
            getIPs(s, prefix + '.', pos, 0, 0, result)
            return getIPs(s, prefix + s[pos], pos + 1, lastByte * 10 + s[pos].digitToInt(), lastByteLen + 1, result)
        }
        // if (prefix.length >= 2 && prefix[prefix.length - 2] == '.')
        if (lastByteLen == 1) {
            getIPs(s, prefix + '.', pos, 0, 0, result)
            return getIPs(s, prefix + s[pos], pos + 1, lastByte * 10 + s[pos].digitToInt(), lastByteLen + 1, result)
        }
    }
}
