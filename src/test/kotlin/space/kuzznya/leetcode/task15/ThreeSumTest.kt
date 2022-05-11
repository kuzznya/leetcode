package space.kuzznya.leetcode.task15

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ThreeSumTest {

    fun f(vararg num: Int) = Solution().threeSum(num).toSet()

    @Test
    fun test() {
//        assertEquals(setOf(listOf(-1, -1, 2), listOf(-1, 0, 1)), f(-1, 0, 1, 2, -1, -4))
//        assertEquals(setOf(listOf(0, 0, 0)), f(0, 0, 0))
        assertEquals(setOf(
            listOf(-4, 0, 4),
            listOf(-4, 1, 3),
            listOf(-3, -1, 4),
            listOf(-3, 0, 3),
            listOf(-3, 1, 2),
            listOf(-2, -1, 3),
            listOf(-2, 0, 2),
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)),
            f(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)
        )
    }
}
