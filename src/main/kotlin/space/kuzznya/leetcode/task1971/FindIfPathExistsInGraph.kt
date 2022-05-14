package space.kuzznya.leetcode.task1971

// using BFS
class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val queue = ArrayDeque<Int>()
        queue.addFirst(source)

        val neighbors = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until n) {
            neighbors[i] = mutableListOf()
        }
        for (e in edges) {
            neighbors[e[0]]?.add(e[1])
            neighbors[e[1]]?.add(e[0])
        }

        val passedVertices = mutableSetOf<Int>()

        while (queue.isNotEmpty()) {
            val vertex = queue.removeFirst()
            if (vertex == destination)
                return true
            if (passedVertices.contains(vertex))
                continue
            passedVertices.add(vertex)
            for (neighbor in neighbors[vertex] ?: mutableListOf()) {
                queue.addLast(neighbor)
            }
        }
        return false
    }
}

// using DFS
class Solution2 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val neighbors = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until n) {
            neighbors[i] = mutableListOf()
        }
        for (e in edges) {
            neighbors[e[0]]?.add(e[1])
            neighbors[e[1]]?.add(e[0])
        }

        val stack = ArrayDeque<Int>()
        stack.addLast(source)

        val visited = mutableSetOf<Int>()

        while (stack.isNotEmpty()) {
            val vertex = stack.removeLast()
            if (vertex == destination)
                return true
            if (visited.contains(vertex))
                continue
            visited.add(vertex)
            for (neighbor in neighbors[vertex] ?: mutableListOf())
                stack.addLast(neighbor)
        }
        return false
    }
}
