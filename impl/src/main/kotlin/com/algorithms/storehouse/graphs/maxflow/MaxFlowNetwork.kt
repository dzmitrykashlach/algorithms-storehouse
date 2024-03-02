package com.algorithms.storehouse.graphs.maxflow

class MaxFlowNetwork constructor(
    val numVertices: Int,
    var adjucenciesList: ArrayList<ArrayList<Edge>> = ArrayList(),

    ) {
    var numEdges: Int = 0

    init {
        for (i in 0 until numVertices) {
            adjucenciesList.add(ArrayList())
        }

    }

    val addEdge = fun(edge: Edge) {
        val from = edge.from
        adjucenciesList[from.id].add(edge)
        numEdges = numEdges + 1
    }

}