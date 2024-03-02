package graphs

import com.algorithms.storehouse.graphs.mst.kruskal.Kruskal
import com.algorithms.storehouse.graphs.mst.kruskal.KruskalEdge
import com.algorithms.storehouse.graphs.mst.kruskal.KruskalVertex
import kotlin.test.assertEquals
import kotlin.test.Test

internal class KruskalTest {
    @Test
    fun testSum() {
        val a = KruskalVertex("A")
        val b = KruskalVertex("B")
        val c = KruskalVertex("C")
        val d = KruskalVertex("D")
        val e = KruskalVertex("E")
        val vertices = mutableListOf<KruskalVertex>()
        vertices.add(a)
        vertices.add(b)
        vertices.add(c)
        vertices.add(d)
        vertices.add(e)

        val edges = mutableListOf<KruskalEdge>()
        val ab = KruskalEdge(5, a, b)
        val bc = KruskalEdge(10, b, c)
        val cd = KruskalEdge(6, c, d)
        val db = KruskalEdge(8, d, b)
        val ac = KruskalEdge(13, a, c)
        val ae = KruskalEdge(15, e, a)
        val ec = KruskalEdge(20, e, c)
        edges.add(ab)
        edges.add(bc)
        edges.add(cd)
        edges.add(db)
        edges.add(ac)
        edges.add(ae)
        edges.add(ec)
        val kruskal = Kruskal()
        assertEquals(34, kruskal.calculate(vertices, edges))
    }
}