package space.kuzznya.leetcode.task1020

class Solution {
    fun numEnclaves(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            runDfs(grid, i, 0)
            runDfs(grid, i, grid[0].size - 1)
        }
        for (j in grid[0].indices) {
            runDfs(grid, 0, j)
            runDfs(grid, grid.size - 1, j)
        }
        return grid.map { it.sum() }.sum()
    }

    private fun runDfs(grid: Array<IntArray>, i: Int, j: Int) {
        if (grid[i][j] == 0) return

        grid[i][j] = 0

        if (i - 1 >= 0) runDfs(grid, i - 1, j)
        if (i + 1 < grid.size) runDfs(grid, i + 1, j)
        if (j - 1 >= 0) runDfs(grid, i, j - 1)
        if (j + 1 < grid[0].size) runDfs(grid, i, j + 1)
    }
}
