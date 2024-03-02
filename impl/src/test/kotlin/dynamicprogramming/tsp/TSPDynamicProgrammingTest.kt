package dynamicprogramming.tsp

import com.algorithms.storehouse.graphs.tsp.TSPDynamicProgramming
import kotlin.test.Test
import kotlin.test.assertEquals

class TSPDynamicProgrammingTest {

    @Test
    fun tspTest_3_vertices() {
        /*
        How to fill adjacency matrix for directed graph:
        - row means vertex, which has outgoing edges;
        - column means vertex, which has incoming edges;
         */
        val graph = arrayOf(
            doubleArrayOf(0.0, 100.0, 1.0),
            doubleArrayOf(1.0, 0.0, 100.0),
            doubleArrayOf(100.0, 1.0, 0.0),
        )
        val tsp = TSPDynamicProgramming(graph)
        tsp.tsp(0, 0)
        assertEquals(3.0, tsp.minTourCost)
        assertEquals("[0, 2, 1, 0]", tsp.tour.toString())


    }

    @Test
    fun tspTest_4_vertices() {
        /*
        How to fill adjacency matrix for directed graph:
        - row means vertex, which has outgoing edges;
        - column means vertex, which has incoming edges;
         */
        val graph = arrayOf(
            doubleArrayOf(0.0, 100.0, 0.0, 1.0),
            doubleArrayOf(0.0, 0.0, 100.0, 0.0),
            doubleArrayOf(1.0, 0.0, 0.0, 100.0),
            doubleArrayOf(100.0, 1.0, 0.0, 0.0),
        )
        val tsp = TSPDynamicProgramming(graph)
        tsp.tsp(0, 0)
        assertEquals(103.0, tsp.minTourCost)
        assertEquals("[0, 2, 1, 3, 0]", tsp.tour.toString())


    }


    @Test
    fun tspTest_5_vertices() {
        /*
        How to fill adjacency matrix for directed graph:
        - row means vertex, which has outgoing edges;
        - column means vertex, which has incoming edges;
         */
        val graph = arrayOf(
            doubleArrayOf(0.0, 9.0, 1.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 11.0, 0.0),
            doubleArrayOf(0.0, 2.0, 0.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 0.0, 20.0),
            doubleArrayOf(40.0, 0.0, 0.0, 0.0, 0.0)
        )
        val tsp = TSPDynamicProgramming(graph)
        tsp.tsp(0, 0)
        assertEquals(74.0, tsp.minTourCost)
        assertEquals("[0, 4, 3, 1, 2, 0]", tsp.tour.toString())


    }

    @Test
    fun tspTest_7_vertices() {
        /*
        How to fill adjacency matrix for directed graph:
        - row means vertex, which has outgoing edges;
        - column means vertex, which has incoming edges;
         */
        val graph = arrayOf(
            doubleArrayOf(0.0, 70.0, 1.0, 0.0, 0.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 30.0, 5.0, 0.0, 0.0, 0.0),
            doubleArrayOf(0.0, 3.0, 0.0, 50.0, 0.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 0.0, 8.0, 100.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 12.0, 175.0),
            doubleArrayOf(0.0, 0.0, 0.0, 0.0, 200.0, 0.0, 16.0),
            doubleArrayOf(10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
        )

        val tsp = TSPDynamicProgramming(graph)
        tsp.tsp(1, 0)
        assertEquals("[0, 6, 5, 4, 3, 1, 2, 0]", tsp.tour.toString())
        assertEquals(55.0, tsp.minTourCost)

    }


    @Test
    fun notInTest() {
        val graph = arrayOf(
            doubleArrayOf(0.0)
        )
        /*
        53 = 0110101
         */
        val tsp = TSPDynamicProgramming(graph)
        assertEquals(true, tsp.notIn(3, 53))
        assertEquals(false, tsp.notIn(4, 53))
    }

    @Test
    fun combinations34() {
        val graph = arrayOf(
            doubleArrayOf(0.0, 9.0, 1.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 11.0, 0.0),
            doubleArrayOf(0.0, 2.0, 0.0, 0.0, 0.0),
            doubleArrayOf(0.0, 0.0, 0.0, 0.0, 20.0),
            doubleArrayOf(40.0, 0.0, 0.0, 0.0, 0.0)
        )
        val tsp = TSPDynamicProgramming(graph)
        /*
        The combinations function generates all bit sets
        of size n with r bits sets set to 1. For example,
        combinations(3,4) = {0111,1011,1101,1110}
         */
        assertEquals(4, tsp.combinations(3, 4).size)
        /*
        tsp.combinations(2, 4)
        ======================
        3 = 0011
        5 = 0101
        9 = 1001
        6 = 0110
        10 = 1010
        12 = 1100
        ======================
         */
        assertEquals(6, tsp.combinations(2, 4).size)

    }
}