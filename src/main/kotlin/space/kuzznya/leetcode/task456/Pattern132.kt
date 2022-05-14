package space.kuzznya.leetcode.task456

// too slow, O(N^2), leading to "Time limit exceeded" for the worst case
class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        if (nums.size < 3) return false
        var maxIdx: Int
        var min = nums[0]

        val intervals = mutableListOf<Pair<Int, Int>>()

        for (i in 1 until nums.size) {
            if (nums[i] < min)
                min = nums[i]

            for (interval in intervals) {
                if (nums[i] > interval.first && nums[i] < interval.second)
                    return true
            }

            if (nums[i] > nums[i - 1] && i + 1 < nums.size && nums[i + 1] < nums[i]) {
                maxIdx = i

                intervals.add(min to nums[maxIdx])

                min = Int.MAX_VALUE
            }
        }

        return false
    }
}
