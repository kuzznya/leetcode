package space.kuzznya.leetcode.task7

import kotlin.math.abs

class Solution {

    // 2^31 = 2147483648

    fun reverse(xArg: Int): Int {
        if (xArg == 0) return 0
        var x = xArg
        val sign = x / abs(x)
        x = abs(x)

        // 2_147_483_648
        if (x >= 1_000_000_000 && x % 10 > 2) return 0

        var result = 0
        var multiplier = 1
        while (x > 0) {
            val t = result
            result *= 10
            if (result / 10 != t) return 0
            result += x % 10
            if (result < 0) return 0
            multiplier *= 10
            x /= 10
        }

        return sign * result
    }
}
