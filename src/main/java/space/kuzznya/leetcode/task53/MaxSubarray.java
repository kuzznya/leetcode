package space.kuzznya.leetcode.task53;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum > 0) currentSum += nums[i];
            else currentSum = nums[i];
            max = Math.max(max, currentSum);
        }
        return max;
    }
}
