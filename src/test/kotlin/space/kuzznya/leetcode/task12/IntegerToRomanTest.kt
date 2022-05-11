package space.kuzznya.leetcode.task12

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IntegerToRomanTest {

    fun f(num: Int) = Solution().intToRoman(num)

    @Test
    fun test() {
        assertEquals("III", f(3))
        assertEquals("IV", f(4))
        assertEquals("IX", f(9))
        assertEquals("XI", f(11))
        assertEquals("LVIII", f(58))
        assertEquals("MCMXCIV", f(1994))
    }
}
