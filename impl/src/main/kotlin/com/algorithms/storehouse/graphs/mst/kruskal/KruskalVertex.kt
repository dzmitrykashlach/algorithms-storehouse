package com.algorithms.storehouse.graphs.mst.kruskal

data class KruskalVertex(
    val name: String,
    var disjointSet: List<KruskalVertex> = emptyList()
) {
    override fun toString(): String = "Vertex - $name"
}