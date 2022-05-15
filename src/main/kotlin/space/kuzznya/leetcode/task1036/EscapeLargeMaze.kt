package space.kuzznya.leetcode.task1036

import kotlin.math.abs

const val GRID_SIZE = 1_000_000

fun Set<Pair<Int, Int>>.isBlocked(x: Int, y: Int): Boolean =
    x < 0 || y < 0 || x >= GRID_SIZE || y >= GRID_SIZE || this.contains(x to y)

class Solution {
    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        val sourcePair = source[0] to source[1]
        val targetPair = target[0] to target[1]
        val blockedList = blocked.map { it[0] to it[1] }
        return limitedBFS(blockedList.toMutableSet(), sourcePair, targetPair) &&
                limitedBFS(blockedList.toMutableSet(), targetPair, sourcePair)
    }

    private fun limitedBFS(blocked: MutableSet<Pair<Int, Int>>,
                           source: Pair<Int, Int>,
                           target: Pair<Int, Int>): Boolean {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(source)

        var checkedSquare = 0

        while (queue.isNotEmpty()) {
            val pos = queue.removeFirst()
            if (pos == target || distance(source, pos) >= 200) // 200 is the max count of blocked points
                return true
            if (checkedSquare >= 200 * 200 / 2) return true
            if (blocked.isBlocked(pos.first, pos.second))
                continue
            blocked.add(pos)
            checkedSquare++
            listOf(
                pos.first - 1 to pos.second,
                pos.first + 1 to pos.second,
                pos.first to pos.second - 1,
                pos.first to pos.second + 1)
                .filter { !blocked.isBlocked(it.first, it.second) }
                .forEach { queue.addLast(it) }
        }
        return false
    }

    private fun distance(p1: Pair<Int, Int>, p2: Pair<Int, Int>) =
        abs(p2.first - p1.first) + abs(p2.second - p1.second)
}
