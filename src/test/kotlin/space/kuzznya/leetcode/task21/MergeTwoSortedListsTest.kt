package space.kuzznya.leetcode.task21

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MergeTwoSortedListsTest {

    private fun f(l1: List<Int>, l2: List<Int>): List<Int> = fromListNode(
        Solution().mergeTwoLists(toListNode(l1), toListNode(l2))
    )

    private fun toListNode(l: List<Int>): ListNode? {
        if (l.isEmpty())
            return null
        val start = ListNode(l.first())
        var p = start
        for (v in l.subList(1, l.size)) {
            p.next = ListNode(v)
            p = p.next!!
        }
        return start
    }

    private fun fromListNode(listNode: ListNode?): List<Int> {
        if (listNode == null)
            return emptyList()
        val l = mutableListOf<Int>()
        var p = listNode
        while (p != null) {
            l.add(p.`val`)
            p = p.next
        }
        return l
    }

    @Test
    fun test() {
        assertEquals(listOf(1, 1, 2, 3, 4, 4), f(listOf(1, 2, 4), listOf(1, 3, 4)))
        assertEquals(listOf(1, 2), f(listOf(2), listOf(1)))
    }
}
