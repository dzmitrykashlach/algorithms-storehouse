package com.algorithms.storehouse.graphs.mst.prim

class Prim {
    var cost: Int = 0

    fun iterateNeighbors(vertex: PrimVertex): Int {
        vertex.visited = true
        val adjMap = vertex.adjucencyList
        for (v: PrimVertex in adjMap.keys) {
            if (!v.visited && v.weight > adjMap[v]!!) {
                v.weight = adjMap[v]!!
            }
        }
        val next: Map.Entry<PrimVertex, Int> =
            try {
                adjMap.filter { a -> !a.key.visited }
                    .minWith { x, y -> x.key.weight.compareTo(y.key.weight) }
            } catch (e: NoSuchElementException) {
                return cost
            }
        cost += next.value
        if (!next.key.visited)
            iterateNeighbors(next.key)
        return cost
    }

}