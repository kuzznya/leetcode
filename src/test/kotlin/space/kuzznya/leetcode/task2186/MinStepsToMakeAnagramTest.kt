package space.kuzznya.leetcode.task2186

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinStepsToMakeAnagramTest {

    private fun f(s: String, t: String) = Solution().minSteps(s, t)

    @Test
    fun test() {
        assertEquals(7, f("leetcode", "coats"))
        assertEquals(27, f("cotxazilut", "nahrrmcchxwrieqqdwdpneitkxgnt"))
    }
}
