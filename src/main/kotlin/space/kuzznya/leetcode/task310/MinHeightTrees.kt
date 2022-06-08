package space.kuzznya.leetcode.task310

class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)

        val graph = createGraph(n, edges)
        val degrees = IntArray(n)

        for (vertex in 0 until n) {
            degrees[vertex] = graph[vertex].size
        }

        val queue = ArrayDeque<Int>()

        for (vertex in degrees.indices) {
            if (degrees[vertex] == 1) {
                queue.addLast(vertex)
                degrees[vertex]--
            }
        }

        val result = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val size = queue.size
            result.clear()
            for (i in 0 until size) {
                val vertex = queue.removeFirst()
                result.add(vertex)
                for (neighbor in graph[vertex]) {
                    degrees[neighbor]--
                    if (degrees[neighbor] == 1)
                        queue.addLast(neighbor)
                }
            }
        }
        return result
    }

    private fun createGraph(n: Int, edges: Array<IntArray>): Array<out List<Int>> {
        val result = Array(n) { ArrayList<Int>() }
        for (edge in edges) {
            result[edge[0]].add(edge[1])
            result[edge[1]].add(edge[0])
        }
        return result
    }
}
