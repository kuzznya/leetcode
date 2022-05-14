package space.kuzznya.leetcode.task849

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MaxDistanceToClosestTest {

    fun f(vararg pos: Int) = Solution().maxDistToClosest(pos)

    @Test
    fun test() {
        assertEquals(3, f(1, 0, 0, 0, 0, 0, 1, 0))
        assertEquals(3, f(0, 0, 0, 1, 0, 0, 1, 0))
        assertEquals(3, f(1, 0, 1, 0, 1, 0, 0, 0))
        assertEquals(2, f(1, 0, 0, 0, 1, 0, 1))
    }
}
