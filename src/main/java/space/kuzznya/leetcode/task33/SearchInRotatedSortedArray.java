package space.kuzznya.leetcode.task33;

import java.util.Arrays;

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int rotationPos = left;

        System.out.println(rotationPos);

        int leftPartSearch = Arrays.binarySearch(nums, 0, rotationPos, target);
        if (leftPartSearch >= 0 && leftPartSearch < rotationPos) return leftPartSearch;

        int rightPartSearch = Arrays.binarySearch(nums, rotationPos, nums.length, target);
        if (rightPartSearch >= 0 && rightPartSearch < nums.length) return rightPartSearch;

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
