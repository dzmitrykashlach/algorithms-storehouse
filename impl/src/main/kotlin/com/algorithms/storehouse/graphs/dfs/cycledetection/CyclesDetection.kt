package com.algorithms.storehouse.graphs.dfs.cycledetection

class CyclesDetection {
    fun detectCycles(graph: List<Vertex>): Vertex {
        for (v in graph) {
            if (!v.visited) {
                return dfs(v)
            }
        }
        return Vertex("")
    }

    private fun dfs(vertex: Vertex): Vertex {
        vertex.beingVisited = true
        for (v in vertex.adjacencyList) {
            if (v.beingVisited) {
                println("Backward edge ... we've got a cycle: v = " + v.name)
                return v
            }
            if (!v.visited) {
                v.visited = true
                return dfs(v)
            }
        }
        vertex.beingVisited = false
        vertex.visited = true
        return Vertex("")
    }

}