package space.kuzznya.leetcode.task236;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        dfs(root, p, pPath);
        Collections.reverse(pPath);
        List<TreeNode> qPath = new ArrayList<>();
        dfs(root, q, qPath);
        Collections.reverse(qPath);

        TreeNode result = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) != qPath.get(i))
                break;
            result = pPath.get(i);
        }
        return result;
    }

    private boolean dfs(TreeNode node, TreeNode target, List<TreeNode> visited) {
        if (node == null) return false;
        if (node == target) {
            visited.add(node);
            return true;
        }
        boolean leftFound = dfs(node.left, target, visited);
        if (leftFound) {
            visited.add(node);
        }
        boolean rightFound = dfs(node.right, target, visited);
        if (rightFound) {
            visited.add(node);
        }
        return leftFound || rightFound;
    }
}
