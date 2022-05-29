package space.kuzznya.leetcode.task1609

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EvenOddTreeTest {

    private fun f(root: TreeNode?) = Solution().isEvenOddTree(root)

    @Test
    fun test() {
        var root = TreeNode(1)
        root.left = TreeNode(4)
        root.right = TreeNode(2)
        assertTrue(f(root))

        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(4)
        assertFalse(f(root))
    }
}
