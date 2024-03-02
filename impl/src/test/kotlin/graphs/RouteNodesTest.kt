package graphs

import com.algorithms.storehouse.graphs.routenodes.RouteNodes
import com.algorithms.storehouse.graphs.routenodes.Vertex
import kotlin.test.assertEquals
import kotlin.test.Test

class RouteNodesTest {

    @Test
    fun routeNodesTest(){
        val routeNodes = RouteNodes()
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        a.adjucencyList.put(b,5)
        b.adjucencyList.put(c,5)
        c.adjucencyList.put(d,5)

        assertEquals(true,routeNodes.check(a,d))
        assertEquals(false,routeNodes.check(d,a))
    }
    @Test
    fun routeNodesTest1(){
        val routeNodes = RouteNodes()
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        val e = Vertex("E")
        val f = Vertex("F")
        val g = Vertex("G")
        val h = Vertex("H")
        val i = Vertex("I")
        val j = Vertex("J")

        a.adjucencyList.put(b,1)
        a.adjucencyList.put(c,1)
        a.adjucencyList.put(d,1)

        b.adjucencyList.put(j,1)
        c.adjucencyList.put(g,1)

        e.adjucencyList.put(a,1)
        e.adjucencyList.put(f,1)
        f.adjucencyList.put(i,1)
        g.adjucencyList.put(d,1)
        g.adjucencyList.put(h,1)


        assertEquals(true,routeNodes.check(a,h))
        assertEquals(false,routeNodes.check(h,a))
    }
}