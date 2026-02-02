package space.kuzznya.leetcode.task22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }

    private void dfs(List<String> result, String prefix, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(prefix);
            return;
        }
        if (left > 0) {
            dfs(result, prefix + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            dfs(result, prefix + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
