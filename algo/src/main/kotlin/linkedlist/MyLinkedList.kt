package linkedlist

class MyLinkedList {
    var head: Node
    var tail: Node
    var count: Int

    init {
        head = Node(-1)
        tail = Node(-1)
        head.next = tail
        tail.prev = head
        count = 0
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1.  */
    operator fun get(index: Int): Int {
        if (index < 0 || index >= count) {
            return -1
        }
        var curr = head.next
        var idx = 0
        while (idx < index) {
            idx++
            curr = curr!!.next
        }
        return curr!!.value
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.  */
    fun addAtHead(value: Int) {
        val newNode = Node(value)
        newNode.next = head.next
        newNode.prev = head
        head.next!!.prev = newNode
        head.next = newNode
        count++
    }

    /** Append a node of value val to the last element of the linked list.  */
    fun addAtTail(value: Int) {
        val newNode = Node(value)
        newNode.prev = tail.prev
        newNode.next = tail
        tail.prev!!.next = newNode
        tail.prev = newNode
        count++
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.  */
    fun addAtIndex(index: Int, value: Int) {
        if (index < 0 || index > count) {
            return
        }
        when (index) {
            0 -> {
                addAtHead(value)
            }
            count -> {
                addAtTail(value)
            }
            else -> {
                var idx = 0
                var curr: Node? = head
                while (idx < index) {
                    idx++
                    curr = curr!!.next
                }
                val newNode = Node(value)
                newNode.prev = curr
                newNode.next = curr!!.next
                curr.next!!.prev = newNode
                curr.next = newNode
                count++
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid.  */
    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= count) {
            return
        }
        var idx = 0
        var curr: Node? = head
        while (idx < index) {
            idx++
            curr = curr!!.next
        }
        val next = curr!!.next!!.next
        next!!.prev = curr
        curr.next = next
        count--
    }
}

class Node(var value: Int) {
    var next: Node? = null
    var prev: Node? = null
}