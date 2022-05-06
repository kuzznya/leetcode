package space.kuzznya.leetcode.task11

import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var p1 = 0
        var p2 = height.size - 1
        var max = (p2 - p1) * min(height[p1], height[p2])
        var h1 = 0
        var h2 = 0
        while (p1 != p2) {
            if (h1 < h2 && height[p1] < h1) {
                p1++
                continue
            } else if (h2 < h1 && height[p2] < h2) {
                p2--
                continue
            }

            val square = (p2 - p1) * min(height[p1], height[p2])
            if (square > max) {
                max = square
            }

            h1 = height[p1]
            h2 = height[p2]

            if (h1 < h2) {
                p1++
            } else {
                p2--
            }
        }
        return max
    }
}
