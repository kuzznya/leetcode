package space.kuzznya.leetcode.task3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LongestSubstrWithoutRepeatingCharsTest {

    fun f(s: String) = Solution().lengthOfLongestSubstring(s)

    @Test
    fun test() {
        assertEquals(3, f("abc"))
        assertEquals(4, f("dabcd"))
        assertEquals(3, f("pwwkew"))
        assertEquals(1, f("bbbbb"))
        assertEquals(3, f("abcabcbb"))
    }
}
