package com.algorithms.storehouse.graphs.bfs.traversal

data class Vertex(
    val id: Int,
    val adjucencyList: MutableList<Edge>,
) {
    var visited: Boolean = false
}