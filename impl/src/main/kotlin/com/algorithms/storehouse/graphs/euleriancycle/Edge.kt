package com.algorithms.storehouse.graphs.euleriancycle

data class Edge constructor(
    val from: Int,
    val to: Int,
) {
    var visited = false
}