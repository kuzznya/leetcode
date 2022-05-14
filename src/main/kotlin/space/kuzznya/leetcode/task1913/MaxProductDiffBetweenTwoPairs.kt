package space.kuzznya.leetcode.task1913

import kotlin.math.*

class Solution {
    fun maxProductDifference(nums: IntArray): Int {
        var max1 = max(nums[0], nums[1])
        var max2 = min(nums[0], nums[1])
        var min1 = max2
        var min2 = max1
        for (i in 2 until nums.size) {
            if (nums[i] > max1) {
                max2 = max1
                max1 = nums[i]
            } else if (nums[i] > max2) {
                max2 = nums[i]
            }

            if (nums[i] < min1) {
                min2 = min1
                min1 = nums[i]
            } else if (nums[i] < min2) {
                min2 = nums[i]
            }
        }
        return max1 * max2 - min1 * min2
    }
}
