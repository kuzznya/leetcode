package space.kuzznya.leetcode.task1753

import kotlin.math.*

class Solution {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        var score = 0

        val aRef = Ref(a)
        val bRef = Ref(b)
        val cRef = Ref(c)

        val l = listOf(aRef, bRef, cRef)
        val min = l.minOrNull()!! // min() in kotlin 1.3
        var max = l.maxOrNull()!! // max() in kotlin 1.3
        if (max == min) {
            max = if (min === aRef) bRef else if (min === bRef) cRef else aRef
        }
        val medium = l.first { it !== min && it !== max }

        val diff = min(max.value - medium.value, min.value)
        score += diff
        max.value -= diff
        min.value -= diff

        if (min.value > 0) {
            score += min.value
            max.value -= min.value / 2
            medium.value -= min.value / 2 + if (min.value % 2 > 0) 1 else 0
            min.value = 0
        }

        score += min(medium.value, max.value)

        return score
    }
}

private data class Ref(
    var value: Int
): Comparable<Ref> {
    override fun compareTo(other: Ref): Int = this.value - other.value
}
