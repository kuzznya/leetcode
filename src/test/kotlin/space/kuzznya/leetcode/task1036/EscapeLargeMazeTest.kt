package space.kuzznya.leetcode.task1036

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EscapeLargeMazeTest {

    private fun f(blocked: List<Pair<Int, Int>>, source: Pair<Int, Int>, target: Pair<Int, Int>) =
        Solution().isEscapePossible(
            blocked.map { intArrayOf(it.first, it.second) }.toTypedArray(),
            intArrayOf(source.first, source.second),
            intArrayOf(target.first, target.second)
        )

    @Test
    fun test() {
        /**
         *  01234
         * 0.....
         * 1...XT
         * 2.S.X.
         * 3.XXX.
         */
        assertTrue(f(
            listOf(
                1 to 3,
                2 to 3,
                3 to 1,
                3 to 2,
                3 to 3
            ),
            2 to 1,
            1 to 4
        ))

        /**
         *  0123
         * 0S.TX
         * 1XXXX
         * 2
         */
        assertTrue(f(listOf(0 to 3, 1 to 0, 1 to 1, 1 to 2, 1 to 3), 0 to 0, 0 to 2))
    }
}
