package com.algorithms.storehouse.graphs.dfs.cycledetection


class Vertex(val name: String) {
    var visited = false
    var beingVisited = false
    val adjacencyList: MutableList<Vertex>

    init {
        adjacencyList = ArrayList()
    }

    fun addNeighbour(vertex: Vertex) {
        adjacencyList.add(vertex)
    }

    override fun toString(): String {
        return name
    }
}