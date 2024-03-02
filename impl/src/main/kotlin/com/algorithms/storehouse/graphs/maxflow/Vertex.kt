package com.algorithms.storehouse.graphs.maxflow

import kotlin.collections.ArrayList

data class Vertex constructor(
    val id: Int
) {
    var adjucencyList: List<Edge> = ArrayList()
}