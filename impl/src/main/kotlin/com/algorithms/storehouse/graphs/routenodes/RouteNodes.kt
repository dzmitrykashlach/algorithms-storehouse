package com.algorithms.storehouse.graphs.routenodes

import java.util.LinkedList

class RouteNodes {
    fun check(from: Vertex, to: Vertex): Boolean {
    var directionExists = false
        val vertices: LinkedList<Vertex> = LinkedList()
        vertices += from.adjucencyList.keys
        while (vertices.isNotEmpty()) {
            val v = vertices.peek()
            vertices.remove()
            if (!v.visited) v.visited = true
            directionExists = v.name == to.name
            if (directionExists) {
                return directionExists
            }
            vertices.addAll(v.adjucencyList.keys)
        }
        return directionExists
    }
}