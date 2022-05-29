package space.kuzznya.leetcode.task1609

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        if (root == null) return true

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var prev: TreeNode? = null
        var levelIdx = 0
        var levelSize = 1
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (levelIdx % 2 == 0 && (node.`val` % 2 == 0 || prev != null && prev.`val` >= node.`val`)) {
                return false
            }
            else if (levelIdx % 2 == 1 && (node.`val` % 2 == 1 || prev != null && prev.`val` <= node.`val`)) {
                return false
            }
            if (node.left != null)
                queue.addLast(node.left!!)
            if (node.right != null)
                queue.addLast(node.right!!)
            prev = node
            levelSize--
            if (levelSize == 0) {
                levelSize = queue.size
                levelIdx++
                prev = null
            }
        }
        return true
    }
}
