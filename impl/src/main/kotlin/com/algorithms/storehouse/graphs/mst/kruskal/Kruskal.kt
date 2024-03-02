package com.algorithms.storehouse.graphs.mst.kruskal

/*
 Time complexity = O(N)
 */
class Kruskal {
    fun calculate(vertices: MutableList<KruskalVertex>, edges: MutableList<KruskalEdge>): Int {
        val verticesLists = HashMap<String, MutableList<KruskalVertex>>()
        for (v: KruskalVertex in vertices) {
            val list: MutableList<KruskalVertex> = mutableListOf(v)
            v.disjointSet = list
            verticesLists.put(v.name, list)
        }
        edges.sort()
        var cost = 0
        var differentSets: Boolean
        for (e: KruskalEdge in edges) {
//             check if first and second vertices are in different lists
            val firstVertexList = e.firstVertex.disjointSet as MutableList
            val secondVertexList = e.secondVertex.disjointSet as MutableList


            differentSets = !(firstVertexList.contains(e.secondVertex)
                    || secondVertexList.contains(e.firstVertex))

            if (differentSets && secondVertexList.isNotEmpty() && firstVertexList.isNotEmpty()) {
                secondVertexList
                    .let {
                        firstVertexList.addAll(it)
                        for (v: KruskalVertex in secondVertexList) {
                            v.disjointSet = firstVertexList
                        }
                        verticesLists.remove(e.secondVertex.name)
                        println("$e is added to MST")
                        cost += e.weight
                    }
            }
        }
        return cost
    }
}