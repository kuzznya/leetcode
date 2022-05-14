package space.kuzznya.leetcode.task1971

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FindIfPathExistsInGraphTest {

    private fun f(n: Int, edges: Array<IntArray>, source: Int, destination: Int) =
        Solution2().validPath(n, edges, source, destination)

    private fun edges(vararg edge: Pair<Int, Int>): Array<IntArray> =
        edge.map { intArrayOf(it.first, it.second) }.toTypedArray()

    @Test
    fun test() {
        assertTrue(f(n = 3, edges = edges(0 to 1, 1 to 2, 2 to 0), source = 0, destination = 2))
        assertFalse(f(n = 6, edges = edges(0 to 1, 0 to 2, 3 to 5, 5 to 4, 4 to 3), source = 0, destination = 5))
        assertTrue(f(10,
            edges(0 to 7, 0 to 8, 6 to 1, 2 to 0, 0 to 4, 5 to 8, 4 to 7, 1 to 3, 3 to 5, 6 to 5),
            7,
            5))
    }
}
