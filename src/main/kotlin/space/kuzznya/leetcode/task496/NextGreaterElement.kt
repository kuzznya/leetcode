package space.kuzznya.leetcode.task496

class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val nextGreater = mutableMapOf<Int, Int>()
        val stack = ArrayDeque<Int>()
        for (n in nums2) {
            while (stack.isNotEmpty() && stack.last() < n) {
                nextGreater[stack.removeLast()] = n
            }
            stack.addLast(n)
        }
        return nums1.map { n -> nextGreater[n] ?: -1 }.toIntArray()
    }
}
