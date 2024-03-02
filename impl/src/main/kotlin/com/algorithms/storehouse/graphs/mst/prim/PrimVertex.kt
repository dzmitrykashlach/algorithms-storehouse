package com.algorithms.storehouse.graphs.mst.prim

class PrimVertex constructor(
    val name: String
) {
    var visited: Boolean = false
    var weight: Int = Int.MAX_VALUE
    var adjucencyList: HashMap<PrimVertex,Int> = hashMapOf()
}