package space.kuzznya.leetcode.task478

import kotlin.math.*
import kotlin.random.Random

class Solution(private val radius: Double, private val x_center: Double, private val y_center: Double) {

    fun randPoint(): DoubleArray {
        val randRadius = sqrt(Random.nextDouble(0.0, 1.0)) * radius
        val degree = Random.nextDouble(0.0, 2 * PI)
        val x = x_center + randRadius * cos(degree)
        val y = y_center + randRadius * sin(degree)
        return doubleArrayOf(x, y)
    }

}
