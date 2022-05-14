package space.kuzznya.leetcode.task1877

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinimizeMaxPairSumTest {

    private fun f(vararg v: Int) = Solution().minPairSum(v)

    @Test
    fun test() {
        assertEquals(7, f(3, 5, 2, 3))
        assertEquals(8, f(3, 5, 4, 2, 4, 6))
    }
}
