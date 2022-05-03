package space.kuzznya.leetcode.task10

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RegexTest {

    fun f(string: String, pattern: String) = Solution().isMatch(string, pattern)

    @Test
    fun test() {
        assertTrue(f("aaa", "a*"))
        assertTrue(f("abc", "abc"))
        assertTrue(f("abcd", "a.*"))
        assertFalse(f("abcd", "abc*"))
        assertTrue(f("abcccc", "abc*"))
        assertTrue(f("abc", ".*"))
        assertTrue(f("abccccddd", "abc*d*"))
        assertTrue(f("abccccddd", "abc*ddd"))
        assertTrue(f("aabbcc", "a*.*cc"))
        assertTrue(f("aaa", "ab*a*c*a"))
        assertTrue(f("a", "ab*"))
        assertTrue(f("abbabaaaaaaacaa", "a*.*b.a.*c*b*a*c*"))
    }
}
