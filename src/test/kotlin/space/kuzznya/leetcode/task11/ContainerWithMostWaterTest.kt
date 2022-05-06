package space.kuzznya.leetcode.task11

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ContainerWithMostWaterTest {

    fun f(vararg height: Int) = Solution().maxArea(intArrayOf(*height))

    @Test
    fun test() {
        assertEquals(49, f(1,8,6,2,5,4,8,3,7))
        assertEquals(1, f(1, 1))
        assertEquals(17, f(2, 3, 4, 5, 18, 17, 6))
    }
}
