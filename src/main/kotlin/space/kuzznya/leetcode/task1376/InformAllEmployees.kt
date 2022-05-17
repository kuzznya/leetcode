package space.kuzznya.leetcode.task1376

class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        var max = informTime[headID]
        val results = IntArray(n) { -1 }
        for (i in 0 until n) {
            val time = informTime(i, headID, manager, informTime, results)
            if (time > max) max = time
        }
        return max
    }

    private fun informTime(employee: Int, headID: Int, manager: IntArray, informTime: IntArray, results: IntArray): Int {
        if (results[employee] != -1)
            return results[employee]
        results[employee] = if (employee == headID) 0 else informTime[manager[employee]] +
                informTime(manager[employee], headID, manager, informTime, results)
        return results[employee]
    }
}
