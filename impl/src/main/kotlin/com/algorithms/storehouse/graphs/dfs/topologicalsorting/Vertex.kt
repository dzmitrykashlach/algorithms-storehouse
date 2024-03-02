package com.algorithms.storehouse.graphs.dfs.topologicalsorting


class Vertex constructor(
    val name: String
) {
    var visited: Boolean = false
    val adjacencyList: MutableList<Vertex> = ArrayList()
    fun addNeighbour(vertex: Vertex) {
        adjacencyList.add(vertex)
    }
}