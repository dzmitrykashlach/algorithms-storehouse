package com.algorithms.storehouse.graphs.tsp

import java.util.*

/*
- define memo table with size = O(N*2^N)
- solution for each subproblem should contain:
  - the set of visited  nodes in the subpath;
  - the index of the last visited node in the path;
https://youtu.be/cY4HiiFHO1o
https://youtu.be/udEe7Cv3DqU

 */

class TSPDynamicProgramming(
    val distance: Array<DoubleArray>,
) {
    private var solved = false
    val n = distance.size
    var tour: LinkedList<Int> = LinkedList<Int>()
    var minTourCost: Double = Double.POSITIVE_INFINITY

    /*
            1<<n = 1*2^n, e.g. 1 is shifted left by n positions
        In Kotlin it equals "1 shl n
        so dp has size = graph.size * 2^graph.size
     */
    val memo: Array<DoubleArray> = Array(n) { DoubleArray(1 shl n) { 0.0 } }
    fun init(start: Int) {
        /*
        DP matrix idea: each vertices sequence is displayed
        as bits in 32-bit integer
        */
        memo.also {
//            we initialize dp memo table with initial values from graph
            for (i in it.indices) {
//                if vertex equals start vertex - we'll skip it, because we do not want
                if (i == start) continue
                /*
                Here we init dp table with distances from start vertex to every other vertex
                 */
                memo[i][(1 shl start) or (1 shl i)] = distance[start][i]
            }
        }
    }

    fun tsp(start: Int, cost: Int) {
        if (!solved) {
            init(start)
            solve(start)
//            min = findMinCost(start)
//            path = findOptimalTour(start)
        }
    }

    fun findOptimalTour(start: Int): LinkedList<Int> {
        TODO("Not yet implemented")
    }

    fun findMinCost(start: Int): Double {
        TODO("Not yet implemented")
    }

    fun solve(start: Int) {
        val endState = (1 shl n) - 1
//        starting from combination of 3 nodes we are iterating through all subsets of vertices
        for (r in 3..n) {
            /*
            e.g. if r = 3 and size = 10 - we're getting all combinations of 3 vertices across 10 vertices initial set
             */
            val combinations = combinations(r, n)
            for (subset: Int in combinations) {
//                if start vertex is not in subset - do nothing
                if (notIn(start, subset)) continue
//                for each vertex from start to end
                for (next in 0 until n) {
//                    the same, if start vertex is not in subset - do nothing
                    if (next == start || notIn(next, subset)) continue
                    /*              The subset state without the next node

                      * */
                    val subsetWithoutNext = subset xor (1 shl next)
                    var minDist = Double.POSITIVE_INFINITY
                    for (end in 0 until n) {
                        if ((end == start) || (end == next) || notIn(end, subset)) continue
                        val newDistance = memo[end][subsetWithoutNext] + distance[end][next]
                        if (newDistance < minDist) {
                            minDist = newDistance
                        }
                    }
                    memo[next][subset] = minDist
                }
            }
        }
        // Connect tour back to starting node and minimize cost.
        for (i in 0 until n) {
            if (i == start) continue
            var tourCost = memo[i][endState] + distance[i][start]
            if (tourCost < minTourCost) {
                minTourCost = tourCost
            }
        }
        var lastIndex = start
        var state = endState
        tour.add(start)

        // Reconstruct TSP path from memo table.
        for (i in 1 until n) {
            var bestIndex = -1.0
            var bestDist = Double.POSITIVE_INFINITY
            for (j in 0 until n) {
                var notIn = notIn(j, state)
                if (j == start || notIn) continue
                var newDist = memo[j][state] + distance[j][lastIndex]
                if (newDist < bestDist) {
                    bestIndex = j.toDouble()
                    bestDist = newDist
                }
            }
            tour.add(bestIndex.toInt())
            state = state xor (1 shl bestIndex.toInt())
            lastIndex = bestIndex.toInt()
        }
        tour.add(start)
        tour.reverse()
        solved = true
    }

    fun combinations(r: Int, n: Int): MutableList<Int> {
        var subsets: MutableList<Int> = mutableListOf()
        combinations(0, 0, r, n, subsets)
        return subsets
    }

    fun combinations(set: Int, at: Int, r: Int, n: Int, subsets: MutableList<Int>) {
        var s = set
        if (r == 0) {
            subsets.add(s)
        } else {
            for (i in at until n) {
//                Flip on i-th bit
                s = s or (1 shl i)
                combinations(s, i + 1, r - 1, n, subsets)
                /*                Backtrack and flipp off i-th bit
                                  More details:
                                  https://www.youtube.com/watch?v=RnlHPR0lyOE
                  * */
                s = s and (1 shl i).inv()
            }
        }
    }

    /*
    Returns true if the i-th bit in 'subset' is not set,
    e.g. i-th vertex is not in this partial route
     */
    fun notIn(i: Int, subset: Int): Boolean {
        return ((1 shl i) and subset) == 0
    }


}