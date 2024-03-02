package com.algorithms.storehouse.graphs.tarjan

import java.util.*


data class Vertex constructor(
    val name: String
) {
    var visited = false
    var onStack: Boolean = false
    var index: Int = Int.MAX_VALUE
    var lowLink: Int = Int.MAX_VALUE
    var adjucencyList: ArrayList<Vertex> = ArrayList()
}