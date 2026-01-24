package space.kuzznya.leetcode.task57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }

        int left = binarySearch(intervals, newInterval[0]);
        int right = binarySearch(intervals, newInterval[1]);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }

        if (left < intervals.length && newInterval[0] > intervals[left][1]) {
            result.add(intervals[left]);
            int newIntervalRight = Math.max(intervals[right][1], newInterval[1]);
            result.add(new int[]{newInterval[0], newIntervalRight});
        } else if (right < intervals.length && newInterval[1] < intervals[right][0]) {
            int newIntervalLeft = Math.min(intervals[left][0], newInterval[0]);
            result.add(new int[]{newIntervalLeft, newInterval[1]});
            result.add(intervals[right]);
        } else {
            int newIntervalLeft = Math.min(intervals[left][0], newInterval[0]);
            int newIntervalRight = Math.max(intervals[right][1], newInterval[1]);
            result.add(new int[]{newIntervalLeft, newIntervalRight});
        }

        for (int i = right + 1; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(int[][]::new);
    }

    private int binarySearch(int[][] intervals, int value) {
        int left = 0;
        int right = intervals.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] <= value && intervals[mid][1] >= value) {
                return mid;
            }
            if (intervals[mid][0] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(right, 0);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(Arrays.deepToString(intervals) +" <- " + Arrays.toString(newInterval));
        int[][] result = insertInterval.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));

        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        System.out.println(Arrays.deepToString(intervals2) + " <- " + Arrays.toString(newInterval2));
        int[][] result2 = insertInterval.insert(intervals2, newInterval2);
        System.out.println(Arrays.deepToString(result2));

        int[][] intervals3 = {{1,5}};
        int[] newInterval3 = {6,8};
        System.out.println(Arrays.deepToString(intervals3) + " <- " + Arrays.toString(newInterval3));
        int[][] result3 = insertInterval.insert(intervals3, newInterval3);
        System.out.println(Arrays.deepToString(result3));

        int[][] intervals4 = {{6, 8}};
        int[] newInterval4 = {1,5};
        System.out.println(Arrays.deepToString(intervals4) + " <- " + Arrays.toString(newInterval4));
        int[][] result4 = insertInterval.insert(intervals4, newInterval4);
        System.out.println(Arrays.deepToString(result4));

        int[][] intervals5 = {{1,5}};
        int[] newInterval5 = {0,3};
        System.out.println(Arrays.deepToString(intervals5) + " <- " + Arrays.toString(newInterval5));
        int[][] result5 = insertInterval.insert(intervals5, newInterval5);
        System.out.println(Arrays.deepToString(result5));

        int[][] intervals6 = {{2,7},{8,8},{10,10},{12,13},{16,19}};
        int[] newInterval6 = {9,17};
        System.out.println(Arrays.deepToString(intervals6) + " <- " + Arrays.toString(newInterval6));
        int[][] result6 = insertInterval.insert(intervals6, newInterval6);
        System.out.println(Arrays.deepToString(result6));
    }
}
