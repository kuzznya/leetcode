package space.kuzznya.leetcode.task39;

import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new java.util.ArrayList<>();
        dfs(candidates, target, 0, result, new java.util.ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> combination) {
        if (target == 0) result.add(List.copyOf(combination));
        if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            combination.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, result, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
