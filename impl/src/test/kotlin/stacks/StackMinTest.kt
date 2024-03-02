package stacks

import com.algorithms.storehouse.stack.StackMin
import kotlin.test.assertEquals
import kotlin.test.Test
class StackMinTest {
    @Test
    fun testMin() {
        val stackMin: StackMin<Int> = StackMin<Int>()
        stackMin.push(10)
        assertEquals(10, stackMin.min() as Int)
        stackMin.push(3)
        assertEquals(3, stackMin.min() as Int)
        stackMin.push(11)
        assertEquals(3, stackMin.min() as Int)
        stackMin.pop()
        assertEquals(3, stackMin.min() as Int)
        stackMin.pop()
        assertEquals(10, stackMin.min() as Int)
        stackMin.push(1)
        assertEquals(1, stackMin.min() as Int)
    }
}
