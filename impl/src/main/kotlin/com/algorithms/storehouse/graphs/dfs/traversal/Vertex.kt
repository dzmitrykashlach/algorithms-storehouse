package com.algorithms.storehouse.graphs.dfs.traversal

data class Vertex(
    val id: Int,
    val adjucencyList: MutableList<Edge>,
) {
    var visited: Boolean = false
}