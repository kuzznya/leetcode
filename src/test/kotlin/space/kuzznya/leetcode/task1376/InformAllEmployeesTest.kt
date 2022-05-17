package space.kuzznya.leetcode.task1376

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InformAllEmployeesTest {

    private fun f(n: Int, headID: Int, manager: IntArray, informTime: IntArray) =
        Solution().numOfMinutes(n, headID, manager, informTime)

    @Test
    fun test() {
        assertEquals(0, f(1, 0, intArrayOf(-1), intArrayOf(0)))
        assertEquals(1, f(6, 2, intArrayOf(2, 2, -1, 2, 2, 2), intArrayOf(0, 0, 1, 0, 0, 0)))
    }
}
