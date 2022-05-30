package space.kuzznya.leetcode.task1020

import org.junit.jupiter.api.Test

internal class NumberOfEnclavesTest {

    private fun f(grid: Array<IntArray>) = Solution().numEnclaves(grid)

    @Test
    fun test() {
        f(arrayOf(intArrayOf(0), intArrayOf(1), intArrayOf(1), intArrayOf(0), intArrayOf(0)))
    }
}
