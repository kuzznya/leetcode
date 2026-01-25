package space.kuzznya.leetcode.task349;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        for (int num : nums1) nums1Set.add(num);
        Set<Integer> result = new HashSet<>(nums1Set.size());
        for (int num : nums2) if (nums1Set.contains(num)) result.add(num);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
