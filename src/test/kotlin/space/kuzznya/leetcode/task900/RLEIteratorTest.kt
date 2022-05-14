package space.kuzznya.leetcode.task900

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RLEIteratorTest {

    @Test
    fun test1() {
        val it = RLEIterator(intArrayOf(3, 8, 2, 4, 1, 5))
        assertEquals(8, it.next(3))
        assertEquals(5, it.next(3))
        assertEquals(-1, it.next(1))
    }

    @Test
    fun test2() {
        val it = RLEIterator(intArrayOf(3, 8, 0, 9, 2, 5))
        assertEquals(8, it.next(2))
        assertEquals(8, it.next(1))
        assertEquals(5, it.next(1))
        assertEquals(-1, it.next(2))
    }

    @Test
    fun test3() {
        val it = RLEIterator(intArrayOf(811,903,310,730,899,684,472,100,434,611))
        assertEquals(903, it.next(358))
        assertEquals(903, it.next(345))
        assertEquals(730, it.next(154))
        assertEquals(684, it.next(265))
        assertEquals(684, it.next(73))
        assertEquals(684, it.next(220))
        assertEquals(684, it.next(138))
        assertEquals(684, it.next(4))
        assertEquals(684, it.next(170))
        assertEquals(684, it.next(88))
    }
}
