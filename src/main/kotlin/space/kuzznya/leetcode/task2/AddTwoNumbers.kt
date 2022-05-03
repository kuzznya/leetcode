package space.kuzznya.leetcode.task2

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun addTwoNumbers(l1Arg: ListNode?, l2Arg: ListNode?): ListNode? {
        var l1 = l1Arg
        var l2 = l2Arg
        var remainder = 0
        while (l1?.next != null) {
            l1.`val` += (l2?.`val` ?: 0) + remainder
            remainder = l1.`val` / 10
            l1.`val` %= 10
            l1 = l1.next
            l2 = l2?.next
        }
        l1!!.`val` += (l2?.`val` ?: 0) + remainder
        remainder = l1!!.`val` / 10
        l1.`val` %= 10
        l2 = l2?.next

        while (l2 != null) {
            var v = l2.`val` + remainder
            remainder = v / 10
            v %= 10
            l1?.next = ListNode(v)
            l1 = l1?.next
            l2 = l2.next
        }
        if (remainder != 0) {
            l1?.next = ListNode(remainder)
            l1 = l1?.next
        }
        return l1Arg
    }
}
