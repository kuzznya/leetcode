package space.kuzznya.leetcode.task849

class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        var p1 = seats.indexOfFirst { it == 1 }
        var max = p1
        while (p1 != seats.size) {
            while (p1 + 1 < seats.size && seats[p1 + 1] == 1) p1++
            if (p1 == seats.size - 2 && max == 0)
                return 1 // in case if only the last seat is free
            if (p1 + 2 >= seats.size) break
            var p2 = p1 + 2
            while (p2 != seats.size && seats[p2] != 1) p2++
            if (p2 == seats.size) {
                if (p2 - p1 - 1 > max) {
                    max = p2 - p1 - 1
//                    println("Went to the end, max found: $max")
                }
                return max
            } else if ((p2 - p1) / 2 > max) {
                max = (p2 - p1) / 2
//                println("Max is between $p1 and $p2: $max")
            }
            p1 = p2
        }
        return max
    }
}
