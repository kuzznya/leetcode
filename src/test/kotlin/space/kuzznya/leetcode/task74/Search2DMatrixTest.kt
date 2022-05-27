package space.kuzznya.leetcode.task74

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Search2DMatrixTest {

    private fun f(matrix: Array<IntArray>, target: Int) = Solution().searchMatrix(matrix, target)

    @Test
    fun test() {
        assertTrue(
            f(arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)),
                5)
        )
        assertFalse(
            f(arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 6, 6),
                intArrayOf(7, 8, 9)),
                5)
        )
        assertFalse(
            f(arrayOf(
                intArrayOf(-9,-7,-7,-5,-3,-3),
                intArrayOf(-1, 1, 2, 2, 4, 6),
                intArrayOf( 8, 8, 8, 8, 8, 9),
                intArrayOf(11,13,15,17,19,19)
            ), 3)
        )
        assertTrue(
            f(arrayOf(
                intArrayOf( 1, 3, 5, 7),
                intArrayOf(10,11,16,20),
                intArrayOf(23,30,34,60)),
                3)
        )
        assertTrue(f(arrayOf(intArrayOf(1, 3)), 3))
    }
}
