package space.kuzznya.leetcode.task8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringToIntegerTest {

    fun f(s: String) = Solution().myAtoi(s)

    @Test
    fun test() {
        assertEquals(123, f("123"))
        assertEquals(-123, f("  -123"))
        assertEquals(123, f("123abc"))
    }
}
