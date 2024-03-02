package arrays

import com.algorithms.storehouse.graphs.citytrip.Trip
import kotlin.test.assertEquals
import kotlin.test.Test
class TripTest {
    @Test
    fun testTrip() {
        val coordinates =
            arrayOf(intArrayOf(2, 1), intArrayOf(5, 3), intArrayOf(5, 6), intArrayOf(2, 7), intArrayOf(0, 4))
        val fuel = 5
        val s = 0
        val d = 3
        val trip = Trip(coordinates, fuel, s, d)
        trip.searchShortestRoutes()
        assertEquals(2, trip.searchShortestRoutes())
    }

    @Test
    fun testTrip1() {
        val coordinates = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(4, 2),
            intArrayOf(5, 2),
            intArrayOf(3, 3)
        )
        val fuel = 2
        val s = 0
        val d = 5
        val trip = Trip(coordinates, fuel, s, d)
        assertEquals(3, trip.searchShortestRoutes())
    }

    @Test
    fun testTrip2() {
        val coordinates = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(4, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 3),
            intArrayOf(3, 4)
        )
        val fuel = 2
        val s = 0
        val d = 5
        val trip = Trip(coordinates, fuel, s, d)
        assertEquals(3, trip.searchShortestRoutes())
    }
}
