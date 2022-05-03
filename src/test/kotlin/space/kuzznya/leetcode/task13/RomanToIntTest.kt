package space.kuzznya.leetcode.task13

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RomanToIntTest {

    val romanToInt = Solution()::romanToInt

    @Test
    fun test() {
        assertEquals(3, romanToInt("III"))
        assertEquals(9, romanToInt("IX"))
        assertEquals(11, romanToInt("XI"))
        assertEquals(58, romanToInt("LVIII"))
        assertEquals(1994, romanToInt("MCMXCIV"))
    }
}
