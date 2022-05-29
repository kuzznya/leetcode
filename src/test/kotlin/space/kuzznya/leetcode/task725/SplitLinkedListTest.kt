package space.kuzznya.leetcode.task725

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SplitLinkedListTest {

    fun List<Int>.toListNodes(): ListNode? {
        if (this.isEmpty()) return null
        val head = ListNode(this[0])
        var tail = head
        for (i in 1 until this.size) {
            tail.next = ListNode(this[i])
            tail = tail.next!!
        }
        return head
    }

    fun ListNode?.toList(): List<Int> {
        var pos = this
        val result = mutableListOf<Int>()
        while (pos != null) {
            result += pos.`val`
            pos = pos.next
        }
        return result
    }

    private fun f(l: List<Int>, k: Int) = Solution().splitListToParts(l.toListNodes(), k).map { it.toList() }

    @Test
    fun test() {
        assertEquals(listOf(listOf(1, 2), listOf(3, 4)), f(listOf(1, 2, 3, 4), 2))
        assertEquals(listOf(listOf(1), listOf(2), listOf(3), listOf(), listOf()), f(listOf(1, 2, 3), 5))
        assertEquals(listOf(listOf(1, 2, 3, 4), listOf(5, 6, 7), listOf(8, 9, 10)), f(listOf(1,2,3,4,5,6,7,8,9,10), 3))
    }
}
