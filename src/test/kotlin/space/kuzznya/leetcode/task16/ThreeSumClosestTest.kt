package space.kuzznya.leetcode.task16

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ThreeSumClosestTest {

    fun f(nums: IntArray, target: Int) = Solution2().threeSumClosest(nums, target)

    @Test
    fun test() {
        assertEquals(2, f(intArrayOf(-1, 2, 1, -4), 1))
        assertEquals(2, f(intArrayOf(1, 1, 1, 0), -100))
        assertEquals(2, f(intArrayOf(-1, 0, 1, 1, 55), 3))
    }
}
