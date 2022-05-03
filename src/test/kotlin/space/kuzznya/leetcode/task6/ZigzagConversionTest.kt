package space.kuzznya.leetcode.task6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ZigzagConversionTest {

    fun f(s: String, numRows: Int) = Solution().convert(s, numRows)

    @Test
    fun testCharsInRow() {
        val f = Solution()::charsInRow
        /**
         * 00        10        20
         * 01      0911      1921
         * 02    08  12    18  22
         * 03  07    13  17    23
         * 0406      1416
         * 05        15
         */
        assertEquals(3, f(24, 6, 0))
        assertEquals(5, f(24, 6, 1))
        assertEquals(5, f(24, 6, 2))
        assertEquals(5, f(24, 6, 3))
        assertEquals(4, f(24, 6, 4))
        assertEquals(2, f(24, 6, 5))

        /**
         * 00      08      16
         * 01    0709    15
         * 02  06  10  14
         * 0305    1113
         * 04      12
         */
        assertEquals(3, f(17, 5, 0))
        assertEquals(4, f(17, 5, 1))
        assertEquals(4, f(17, 5, 2))
        assertEquals(4, f(17, 5, 3))
        assertEquals(2, f(17, 5, 4))
    }

    @Test
    fun test() {
        /**
         * a e i
         * bdfhj
         * c g
         */
        assertEquals("aeibdfhjcg", f("abcdefghij", 3))

        /**
         * a  g  m
         * b fh l
         * ce ik
         * d  j
         */
        assertEquals("agmbfhlceikdj", f("abcdefghijklm", 4))

        assertEquals("abcd", f("abcd", 1))

        /**
         * ace
         * bd
         */
        assertEquals("acebd", f("abcde", 2))

        /**
         * a
         * b
         * ce
         * d
         */
        val s = Solution()
        println(s.charsInRow(5, 4, 0))
        println(s.charsInRow(5, 4, 1))
        println(s.charsInRow(5, 4, 2))
        println(s.charsInRow(5, 4, 3))
        assertEquals("abced", f("abcde", 4))
    }
}
