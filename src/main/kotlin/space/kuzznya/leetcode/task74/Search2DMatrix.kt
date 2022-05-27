package space.kuzznya.leetcode.task74

// not the fastest solution but still ok
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        if (matrix[0][0] > target) return false
        if (matrix[0][0] == target) return true

        var left = 0
        var right = m - 1

        while (left < right) {
            val mid = (left + right) / 2
            if (matrix[mid][0] == target) {
                left = mid
                right = mid
                break
            }
            if (matrix[mid][0] < target) left = mid + 1
            else if (matrix[mid][0] > target) right = mid - 1
        }
        if (matrix[left][0] == target) return true
        if (matrix[left][0] > target) left--

        val i = left
        if (i > matrix[i][n - 1]) return false
        val pos = matrix[i].binarySearch(target)
        return pos > 0
    }
}


// It seems that the solution below is actually slower

fun Array<IntArray>.getInList(i: Int) = this[i / this[0].size][i % this[0].size]

class Solution2 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix[0][0] > target) return false
        if (matrix[0][0] == target) return true

        var left = 0
        var right = matrix.size * matrix[0].size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (matrix.getInList(mid) < target) left = mid + 1
            else if (matrix.getInList(mid) > target) right = mid - 1
            else return true
        }
        return false
    }
}
