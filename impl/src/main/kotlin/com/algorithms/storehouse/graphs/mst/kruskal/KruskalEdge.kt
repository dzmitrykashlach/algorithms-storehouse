package com.algorithms.storehouse.graphs.mst.kruskal

data class KruskalEdge(
    val weight: Int,
    val firstVertex: KruskalVertex,
    val secondVertex: KruskalVertex
) : Comparable<KruskalEdge> {
    override fun compareTo(other: KruskalEdge): Int {
        return weight - other.weight
    }
}