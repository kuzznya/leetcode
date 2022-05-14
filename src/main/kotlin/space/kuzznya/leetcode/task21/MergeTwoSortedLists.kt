package space.kuzznya.leetcode.task21

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null)
            return null
        if (list1 == null && list2 != null)
            return list2

        var prevPos1 = ListNode(Int.MIN_VALUE) // dummy node
        prevPos1.next = list1
        val result = prevPos1
        var pos1 = list1
        var pos2 = list2
        while (pos1 != null && pos2 != null) {
            if (pos1.`val` <= pos2.`val`) {
                prevPos1 = pos1
                pos1 = pos1.next
            } else {
                val valueToInsert = pos2
                pos2 = pos2.next
                prevPos1.next = valueToInsert
                valueToInsert.next = pos1
                prevPos1 = prevPos1.next!!
            }
        }

        if (pos2 != null)
            prevPos1.next = pos2

        return result.next
    }
}
