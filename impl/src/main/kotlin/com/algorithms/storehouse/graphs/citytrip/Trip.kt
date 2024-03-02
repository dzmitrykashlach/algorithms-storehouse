package com.algorithms.storehouse.graphs.citytrip

import java.util.*
import java.util.function.Predicate
import kotlin.math.abs

class Trip(coordinates: Array<IntArray>, fuel: Int, s: Int, d: Int) {
    private val fuel: Int
    private val s: Int
    private val d: Int
    private val map = LinkedHashMap<Int, City>()

    init {
        for (i in coordinates.indices) {
//                set up map with cities - O(N) time complexity;
            map[i] = City(i, coordinates[i][0], coordinates[i][1])
        }
        //            volume of fuel
        this.fuel = fuel
        //            this route we should find as result
        this.s = s
        this.d = d
    }

    fun searchShortestRoutes(): Int {
//        get reachable cities from s;
        val source = map[s]
        val destination = map[d]
        //        define direction of moving - X or Y
        val horizontalDirection = destination!!.x - source!!.x > destination.y - source.y
        //        Check that next city is before destination
        val beforeDestination =
            if (horizontalDirection) Predicate { city: City -> city.x <= destination.x } else Predicate { city: City -> city.y <= destination.y }
        //        Check that next city is after source
        val afterSource =
            if (horizontalDirection) Predicate { city: City -> city.x > source.x } else Predicate { city: City -> city.y > source.y }
        val reachable: Queue<City> = LinkedList(map.values.stream().filter(afterSource)
            .filter(beforeDestination)
            .filter { city: City -> distance(source, city) <= fuel }
            .toList())
        var pathCount = 0
        while (!reachable.isEmpty()) {
            val from = reachable.poll()
            //            if city id equals to destination id - we've found 1 more route;
            if (from.id == destination.id) {
                pathCount++
            }
            val afterFrom =
                if (horizontalDirection) Predicate { city: City -> city.x > from.x } else Predicate { city: City -> city.y > from.y }
            val toAdd = map.values.stream()
                .filter(beforeDestination.and(afterFrom)
                    .and { city: City -> distance(from, city) <= fuel })
                .toList()
            reachable.addAll(toAdd)
        }
        return pathCount
    }

    fun distance(city1: City?, city2: City): Int {
        return abs(city1!!.x - city2.x) + abs(city1.y - city2.y)
    }
}