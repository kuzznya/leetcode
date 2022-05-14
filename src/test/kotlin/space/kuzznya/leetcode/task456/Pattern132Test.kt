package space.kuzznya.leetcode.task456

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Pattern132Test {

    private fun f(vararg v: Int) = Solution().find132pattern(v)

    @Test
    fun test() {
        assertFalse(f(1, 2, 3, 4))
        assertTrue(f(1, 2, 4, 3))
        assertTrue(f(3, 1, 4, 2))
        assertTrue(f(-1, 3, 2, 0))
        assertTrue(f(1, 3, 2, 4, 5, 6, 7, -1, 0))
        assertTrue(f(1, 3, 2, 4, 5, 6, 7, 8, 9, 10))
    }
}
