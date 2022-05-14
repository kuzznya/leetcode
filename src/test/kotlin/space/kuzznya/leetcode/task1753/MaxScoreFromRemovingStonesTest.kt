package space.kuzznya.leetcode.task1753

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MaxScoreFromRemovingStonesTest {

    private fun f(a: Int, b: Int, c: Int) = Solution().maximumScore(a, b, c)

    @Test
    fun test() {
        assertEquals(6, f(2, 4, 6))
        assertEquals(7, f(4, 4, 6))
        assertEquals(149999, f(99999, 100000, 100000))
        assertEquals(150000, f(100000, 100000, 100000))
        assertEquals(3, f(6, 2, 1))
    }
}
