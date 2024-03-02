package lists.leetcode

import com.algorithms.storehouse.entities.linkedlist.leetcode.ListNode
import org.junit.Test
import kotlin.test.fail

class SwapNodesPairs {

    /*
    TODO
    https://www.enjoyalgorithms.com/blog/swap-list-nodes-in-pairs
     */
    fun swap(l: ListNode): ListNode? {
        if (l.next == null) {
            return l
        }
        var p = l
        var head = l.next
        while (p != null && p.next != null) {
            val tmp = p.next
            p.next = p.next!!.next
            if (tmp != null) {
                tmp.next = p.next
            }
            p = p.next!!
            if (p!=null && p.next!=null){
                if (tmp != null) {
                    tmp.next?.next = p.next
                }
            }
        }

        return head
    }

    @Test
    fun `1-2-3-4`() {
        val l: ListNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                        ListNode(
                            5,
                            ListNode(6)
                        )
                    )
                )
            )
        )

        var r = SwapNodesPairs().swap(l)
        fail()
    }

    @Test
    fun `1-2-3-4-5`() {
        val l: ListNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                        ListNode(
                            5
                        )
                    )
                )
            )
        )

        var r = SwapNodesPairs().swap(l)
        fail()
    }

    @Test
    fun `1`() {
        val l: ListNode = ListNode(
            1
        )

        var r = SwapNodesPairs().swap(l)
        fail()
    }
}