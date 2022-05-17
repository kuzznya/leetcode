package space.kuzznya.leetcode.task962

class Solution {
    fun maxWidthRamp(nums: IntArray): Int {
        var max = 0
        val maxRightValues = IntArray(nums.size)
        maxRightValues[nums.size - 1] = nums.last()
        for (i in nums.size - 2 downTo 0) {
            maxRightValues[i] = kotlin.math.max(nums[i], maxRightValues[i + 1])
        }

        var i = 0
        for (j in nums.indices) {
            while (i < j && nums[i] > maxRightValues[j]) // we're skipping till the current right maximum, because we know that after some iterations nums[j] will be this maximum and it would be more optimal than current nums[j]
                i++
            if (j - i > max) max = j - i
        }
        return max
    }
}
