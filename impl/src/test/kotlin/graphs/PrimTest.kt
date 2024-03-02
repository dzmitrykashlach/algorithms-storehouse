package graphs

import com.algorithms.storehouse.graphs.mst.prim.Prim
import com.algorithms.storehouse.graphs.mst.prim.PrimVertex
import kotlin.test.assertEquals
import kotlin.test.Test

class PrimTest {
    @Test
    fun primCalculationTest() {
        val a = PrimVertex("A")
        val b = PrimVertex("B")
        val c = PrimVertex("C")
        val d = PrimVertex("D")
        val e = PrimVertex("E")


        a.adjucencyList[b] = 5
        b.adjucencyList[a] = 5

        a.adjucencyList[c] = 13
        c.adjucencyList[a] = 13

        b.adjucencyList[c] = 10
        c.adjucencyList[b] = 10

        b.adjucencyList[d] = 8
        d.adjucencyList[b] = 8

        d.adjucencyList[c] = 6
        c.adjucencyList[d] = 6

        a.adjucencyList[e] = 15
        e.adjucencyList[a] = 15

        e.adjucencyList[c] = 20
        c.adjucencyList[e] = 20

        e.weight=0

        assertEquals(34, Prim().iterateNeighbors(e))
       }
}