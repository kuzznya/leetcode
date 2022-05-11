package space.kuzznya.leetcode.task16

import kotlin.math.abs

// less efficient but working solution using binary search
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size < 4) return nums.sum()

        var result = nums[0] + nums[1] + nums[2]
        nums.sort()
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i - 1] == nums[i]) continue

            for (j in i + 1 until nums.size - 1) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue

                val kVal = target - nums[i] - nums[j]
                var k = nums.binarySearch(kVal, j + 1)
                if (k < 0) k = -(k + 1)
                if (k != nums.size && abs(target - result) > abs(target - nums[i] - nums[j] - nums[k])) {
                    result = nums[i] + nums[j] + nums[k]
                }
                if (k - 1 != j && abs(target - result) > abs(target - nums[i] - nums[j] - nums[k - 1])) {
                    result = nums[i] + nums[j] + nums[k - 1]
                }

                if (result == target) return result
            }
        }

        return result
    }
}

// more efficient solution using two pointers
class Solution2 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size < 4) return nums.sum()

        var result = nums[0] + nums[1] + nums[2]
        nums.sort()
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i - 1] == nums[i]) continue

            var j = i + 1
            var k = nums.size - 1

            while (j != k) {
                val sum = nums[i] + nums[j] + nums[k]

                if (sum == target)
                    return sum
                else if (sum < target) {
                    j++
                } else {
                    k--
                }

                if (abs(target - sum) < abs(target - result))
                    result = sum
            }
        }

        return result
    }
}
