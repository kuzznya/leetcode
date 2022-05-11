package space.kuzznya.leetcode.task14

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs[0].isEmpty()) return ""
        var pos = 0
        while (strs.all { it.length > pos && it[pos] == strs[0][pos] }) pos++
        return strs[0].substring(0, pos)
    }
}
