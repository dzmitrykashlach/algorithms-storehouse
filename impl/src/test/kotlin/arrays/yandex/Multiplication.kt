package arrays.yandex

import kotlin.test.Test
import kotlin.test.assertEquals

/*

https://en.wikipedia.org/wiki/Integer_factorization

 */
class Multiplication {
    //        map for storing divisors, key = element, value = list of element's indexes
    var divisors = HashMap<Int, ArrayList<Int>>()
    var result = ArrayList<Int>()
    fun search(n: Int, m: Int, k: Int, a: IntArray): IntArray {
        for (i in a.indices) {
            if (m % a[i] == 0) {
                if (divisors[a[i]] != null) {
                    divisors[a[i]]!!.add(i)
                } else {
                    divisors[a[i]] = ArrayList<Int>().also { it.add(i) }
                }
            }
        }
        decompose(m, k)

//       replace divisors values with their indices
        for (value in result) {
            val index = divisors[value]!![0]
            divisors[value]!!.removeFirst()
            if (divisors[value]!!.size == 0) {
                divisors.remove(value)
            }
            result[result.lastIndexOf(value)] = index
        }
        return result.toIntArray()
    }

    fun decompose(number: Int, k: Int) {
//        FIXME
    }

    @Test
    fun `9 1 1 27 3 27 3 - 1`() {
        val result = Multiplication().search(
            7, 27, 1, intArrayOf(9, 1, 1, 27, 3, 27, 3)
        )
        assertEquals(1, result.size)
        assertEquals(27, result[0])
    }

    @Test
    fun `9 1 1 27 3 27 3 - 2`() {
        val m = 27
        val k = 2
        val array = intArrayOf(9, 1, 1, 27, 3, 27, 3)
        val result = Multiplication().search(
            7, m, k, array
        )

        var product = 1
        for (element in result) {
            product *= array[element]
        }
        assertEquals(m, product)
        assertEquals(2, result.size)
    }

    @Test
    fun `30 1 1 3 10 6 4 - 4`() {
        val m = 60
        val k = 4
        val array = intArrayOf(30, 1, 1, 3, 10, 6, 4)

        val result = Multiplication().search(
            7, m, k, array
        )

        var product = 1
        for (element in result) {
            product *= array[element]
        }
        assertEquals(m, product)
        assertEquals(k, result.size)


    }
}