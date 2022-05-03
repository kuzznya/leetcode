package space.kuzznya.leetcode.task5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LongestPalindromeSubstrTest {

    fun f(s: String) = Solution2().longestPalindrome(s)

    @Test
    fun testIsPalindrome() {
        assertTrue(Solution().isPalindrome("abad", 0, 3))
        assertTrue(Solution().isPalindrome("dabad", 0, 5))
        assertTrue(Solution().isPalindrome("dddabcddcba123", 3, 11))
        assertTrue(Solution().isPalindrome("a", 0, 0))
        assertFalse(Solution().isPalindrome("abcd", 0, 3))
    }

    @Test
    fun test() {
        assertEquals("aba", f("abad"))
        assertEquals("bb", f("cbbd"))
        val longStr = "a".repeat(1000)
        assertEquals(longStr, f(longStr))

        assertEquals("abccba", f("123abccba123"))
        assertEquals("abcba", f("123abcba123"))
        assertEquals("abccba", f("123abccba"))
        assertEquals("abcba", f("123abcba"))
        assertEquals("abccba", f("abccba123"))
        assertEquals("abcba", f("abcba123"))
        assertEquals("a", f("a"))
    }
}
