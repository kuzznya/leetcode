package space.kuzznya.leetcode.task1877

class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        return (0 until nums.size / 2).maxOf { nums[it] + nums[nums.size - it - 1] }
    }
}
