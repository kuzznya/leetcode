package space.kuzznya.leetcode.task1013

class Solution {
    fun canThreePartsEqualSum(arr: IntArray): Boolean {
        val sum = arr.sum()
        var p1 = 0
        var p2 = arr.size - 1
        var sum1 = arr[p1++]
        var sum2 = arr[p2--]
        var changed = false
        while (p1 < p2) {
            if (sum1 != sum / 3) {
                sum1 += arr[p1++]
                changed = true
            }
            if (p1 < p2 && sum2 != sum / 3) {
                sum2 += arr[p2--]
                changed = true
            }
            if (sum1 == sum2 && sum - sum1 - sum1 == sum1) return true
            if (!changed) return false
            changed = false
        }
        return false
    }
}
