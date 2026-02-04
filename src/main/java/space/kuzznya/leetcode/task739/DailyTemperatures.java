package space.kuzznya.leetcode.task739;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> warmerDays = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!warmerDays.isEmpty() && temperatures[warmerDays.peek()] < temperatures[i]) {
                int prev = warmerDays.pop();
                result[prev] = i - prev;
            }
            warmerDays.push(i);
        }
        return result;
    }
}
