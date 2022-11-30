package linkedlist

class LinkedListSolutions {
    companion object {
        /**
         * Reverse Linked List
         * T: O(n) M: O(1)
         */
        fun reverseList(head: ListNode?): ListNode? {
            var prev: ListNode? = null
            var current = head
            while (current != null) {
                val temp = current.next
                current.next = prev
                prev = current
                current = temp
            }
            return prev
        }

        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            var newList1 = list1
            var newList2 = list2

            var dummyNode = ListNode(0)
            //tail for cases ex: L1: 1 -> 2 -> 3 vs L2: 1 -> 2 -> 3 -> 4 -> 5
            // in case L1 is null, tail.next = L2.next or vice versus
            var tail = dummyNode

            while (newList1 != null && newList2 != null) {
                if (newList1.value < newList2.value) {
                    tail.next = newList1
                    newList1 = newList1.next
                } else {
                    tail.next = newList2
                    newList2 = newList2.next
                }
                tail = tail.next!!
                println("tail: ${tail.value}")
            }


            if (newList1 != null) {
                println("newList1: ${newList1.value}")
                tail.next = newList1
            }

            if (newList2 != null) {
                println("newList2: ${newList2.value}")
                tail.next = newList2
            }
            return dummyNode.next // dummy -> 1 -> 2 -> ... so head of list is dummy.next
        }

        fun reorderList(head: ListNode?): Unit {
            //1. find the middle node
            var slow = head
            var fast = head?.next
            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
            }

            //2. reverse the second list(the right part of list)
            //2.1 head of second list is slow.next
            var secondHead = slow?.next
            //middle node is the tail of the list. It's going to point to null
            slow?.next = null
            var prev: ListNode? = null
            while (secondHead != null) {
                val next = secondHead.next

                secondHead.next = prev
                prev = secondHead
                secondHead = next
            }
            //merge 2 list together
            secondHead = prev //after reverse the second part -> prev is the last node of the second
            var firstHead = head

            while (secondHead != null) {
                //because secondHead could be shorter than first
                val tmp1 = firstHead?.next
                val tmp2 = secondHead.next

                firstHead?.next = secondHead
                secondHead.next = tmp1

                firstHead = tmp1
                secondHead = tmp2
            }

        }

        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            val dummy = ListNode(0)
            dummy.next = head

            var left: ListNode? = dummy
            var right = head
            var loop = n
            //move right ptr to the right position (head + 2)
            //distance between left and right is n. however, to delete we should have n-1 node
            //
            while (loop > 0) {
                right = right?.next
                loop--
            }

            //move each until right is null
            //after the loop, right is null, left is nth - 1
            while (right != null) {
                left = left?.next
                right = right.next
            }

            left?.next = left?.next?.next


            return dummy.next
        }
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null

    fun print() {
        println(print(this))
    }
    private fun print(head: ListNode?): String {
        if (head == null) {
            return "NULL"
        }

        return " ${head.value} -> " + print(head.next)
    }
}