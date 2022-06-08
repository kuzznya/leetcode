package space.kuzznya.leetcode.task310

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinHeightTreesTest {

    private fun f(n: Int, vararg edges: Pair<Int, Int>) = Solution()
        .findMinHeightTrees(n, edges.map { intArrayOf(it.first, it.second) }.toTypedArray())

    @Test
    fun test() {
        /**       2
         *       /
         * 0 - 1
         *       \
         *        3
         */
        assertEquals(setOf(1), f(4, 1 to 0, 1 to 2, 1 to 3).toSet())
    }
}
