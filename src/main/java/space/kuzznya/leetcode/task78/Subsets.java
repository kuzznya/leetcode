package space.kuzznya.leetcode.task78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(nums, 0, result, combination);
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> combination) {
        if (index == nums.length) {
            result.add(List.copyOf(combination));
            return;
        }

        dfs(nums, index + 1, result, combination);
        combination.add(nums[index]);
        dfs(nums, index + 1, result, combination);
        combination.remove(combination.size() - 1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }
}
