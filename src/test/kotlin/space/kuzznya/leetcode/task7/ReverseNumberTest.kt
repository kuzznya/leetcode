package space.kuzznya.leetcode.task7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ReverseNumberTest {

    fun f(x: Int) = Solution().reverse(x)

    @Test
    fun test() {
        assertEquals(321, f(123))
        assertEquals(1, f(1))
        assertEquals(1, f(1000))
        assertEquals(-321, f(-123))
        assertEquals(0, f(2147483647))
        assertEquals(0, f(1534236469))
    }
}
