package space.kuzznya.leetcode.task14

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LongestCommonPrefixTest {

    fun f(vararg s: String) = Solution().longestCommonPrefix(arrayOf(*s))

    @Test
    fun test() {
        assertEquals("fl", f("flower","flow","flight"))
    }
}
