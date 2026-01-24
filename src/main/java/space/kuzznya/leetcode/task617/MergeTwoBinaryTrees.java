package space.kuzznya.leetcode.task617;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        int val;
        if (root1 != null && root2 != null) val = root1.val + root2.val;
        else val = root1 != null ? root1.val : root2.val;

        TreeNode result = new TreeNode(val);

        result.left = merge(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        result.right = merge(root1 != null ? root1.right : null, root2 != null ? root2.right : null);

        return result;
    }
}
