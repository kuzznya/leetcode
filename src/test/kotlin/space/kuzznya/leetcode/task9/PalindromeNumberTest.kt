package space.kuzznya.leetcode.task9

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PalindromeNumberTest {

    fun f(x: Int) = Solution().isPalindrome(x)

    @Test
    fun test() {
        assertTrue(f(121))
        assertFalse(f(123))
        assertFalse(f(1000021))
    }
}
