package space.kuzznya.leetcode.task9

// bad solution but it works
class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x < 10) return true

        val s = x.toString()
        return s == s.reversed()
    }
}
