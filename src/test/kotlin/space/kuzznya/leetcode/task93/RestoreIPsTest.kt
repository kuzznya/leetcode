package space.kuzznya.leetcode.task93

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RestoreIPsTest {

    private fun f(s: String) = Solution().restoreIpAddresses(s)

    @Test
    fun test() {
        assertEquals(listOf("1.1.1.1"), f("1111"))
        assertEquals(listOf("255.255.255.255"), f("255255255255"))
        assertEquals(listOf("255.255.11.135", "255.255.111.35"), f("25525511135"))
        assertEquals(listOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"), f("101023"))
    }
}
