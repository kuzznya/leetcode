package space.kuzznya.leetcode.task15

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val result = mutableListOf<List<Int>>()
        nums.sort()
        val map = nums.mapIndexed { idx, value -> value to idx }.toMap()
        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i - 1] == nums[i]) continue

            for (j in i + 1 until nums.size - 1) {
                if (nums[i] + nums[j] > 0) break
                if (j > i + 1 && nums[j - 1] == nums[j]) continue

                val k = map[- nums[i] - nums[j]]
                if (k != null && k > i && k > j)
                    result += listOf(nums[i], nums[j], - nums[i] - nums[j])
            }
        }
        return result
    }
}
