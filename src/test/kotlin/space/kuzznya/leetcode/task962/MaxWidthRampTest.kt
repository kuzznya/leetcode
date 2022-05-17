package space.kuzznya.leetcode.task962

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MaxWidthRampTest {

    private fun f(nums: IntArray) = Solution().maxWidthRamp(nums)

    @Test
    fun test() {
        assertEquals(4, f(intArrayOf(6, 0, 8, 2, 1, 5)))
    }
}
