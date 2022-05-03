package space.kuzznya.leetcode.task2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AddTwoNumbersTest {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?) = Solution().addTwoNumbers(l1, l2)

    @Test
    fun testSupportingTestFuncs() {
        val l = intToList(123)
        println("A")
        assertEquals(3, l.`val`)
        assertEquals(2, l.next?.`val`)
        assertEquals(1, l.next?.next?.`val`)
        val v = listToInt(l)
        assertEquals(123, v)
    }

    @Test
    fun test() {
        compareResult(123, 456)
        compareResult(1837, 445)
        compareResult(342, 465)
        compareResult(0, 0)
        compareResult(9999999, 9999)
    }

    fun compareResult(v1: Int, v2: Int) = println("$v1 + $v2").also { assertEquals(v1 + v2, getResult(v1, v2)) }

    fun getResult(v1: Int, v2: Int) = listToInt(addTwoNumbers(intToList(v1), intToList(v2))!!)

    private fun intToList(iArg: Int): ListNode {
        var i = iArg
        var result: ListNode? = null
        var end: ListNode? = null
        while (i > 0) {
            if (result == null) {
                result = ListNode(i % 10)
                end = result
            } else {
                end!!.next = ListNode(i % 10)
                end = end.next
            }
            i /= 10
        }
        return result ?: ListNode(0)
    }

    private fun listToInt(lArg: ListNode): Int {
        var l: ListNode? = lArg
        var result = 0
        var multiplier = 1
        while (l != null) {
            if (l.`val` < 0 || l.`val` >= 10)
                throw RuntimeException("Invalid digit ${l.`val`}")
            result += l.`val` * multiplier
            multiplier *= 10
            l = l.next
        }
        return result
    }
}
