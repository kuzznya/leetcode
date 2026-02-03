package space.kuzznya.leetcode.task77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(n, k, 1, result, combination);
        return result;
    }

    private void dfs(int n, int k, int index, List<List<Integer>> result, List<Integer> combination) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i <= n - k + combination.size() + 1; i++) {
            combination.add(i);
            dfs(n, k, i + 1, result, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
