package stacks

import com.algorithms.storehouse.entities.stack.StackSet
import kotlin.test.assertEquals
import kotlin.test.Test
class StackSetTest {
    @Test
    fun stackTest() {
        val stackSet: StackSet<Int> = StackSet<Int>(3)
        stackSet.push(0)
        stackSet.push(1)
        stackSet.push(2)
        stackSet.push(3)
        assertEquals(2, stackSet.numOfStacks())
        stackSet.push(4)
        stackSet.push(5)
        stackSet.push(6)
        assertEquals(3, stackSet.numOfStacks())
        val i: Int = stackSet.popAt(1)
        assertEquals(5, i)
        stackSet.popAt(1)
        stackSet.popAt(1)
        assertEquals(2, stackSet.numOfStacks())
        try {
            stackSet.popAt(2)
        } catch (e: java.lang.IndexOutOfBoundsException) {
            assertEquals(2, stackSet.numOfStacks())
        }
        assertEquals(6, stackSet.pop() as Int)
    }
}
