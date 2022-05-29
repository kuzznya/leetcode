package space.kuzznya.leetcode.task725

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode.size(): Int = 1 + (next?.size() ?: 0)

class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        if (head == null) {
            return Array(k) { null }
        }
        val size = head.size()
        val partSize = size / k
        var partsWithAdditional = size % k
        val result = Array<ListNode?>(k) { null }
        var l: ListNode? = head
        var partIdx = 0
        while (l != null) {
            result[partIdx] = l
            for (i in 0 until partSize - 1 + if (partsWithAdditional > 0) 1 else 0) {
                l = l?.next
            }
            partsWithAdditional--
            val partTail = l
            l = l?.next
            partTail?.next = null
            partIdx++
        }
        return result
    }
}
