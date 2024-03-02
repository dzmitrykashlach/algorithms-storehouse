package com.algorithms.storehouse.graphs.routenodes


class Vertex constructor(
    val name: String
) {
    var visited: Boolean = false
    var weight: Int = Int.MAX_VALUE
    var adjucencyList: HashMap<Vertex,Int> = hashMapOf()
}