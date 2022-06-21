package hash

class MyHashMap {
    //
//    private val data = IntArray(1000001) {
//        -1
//    }
//
//    fun put(key: Int, value: Int) {
//        data[key] = value
//    }
//
//    fun get(key: Int): Int {
//        if (key < 0) {
//            return -1
//        }
//        return data[key]
//    }
//
//    fun remove(key: Int) {
//        if (key < 0) {
//            return
//        }
//        data[key] = -1
//    }
    private val size = 1000001
    private val data = Array<Node?>(size) {
        null
    }

    private fun hash(key: Int): Int {
        return key % size
    }

    fun put(key: Int, value: Int) {
        //remove() to avoid chaining multiple versions of a key definition
        remove(key)
        val hashCode = hash(key)
        //form a new ListNode at the head of the proper hashmap bucket, pushing any others back.
        val node = Node(key, value, data[hashCode])
        data[hashCode] = node
    }

    fun get(key: Int): Int {
        val hashCode = hash(key)
        if(key < 0) {
            return -1
        }
        var node = data[hashCode]
        while (node != null) {
            if (node.key == key) {
                return node.value
            }
            node = node.next
        }
        return -1
    }

    fun remove(key: Int) {
        val hashCode = hash(key)
        var node = data[hashCode] ?: return
        if (node.key == key) {
            data[hashCode] = node.next
        }
        while (node.next != null) {
            if (node.next!!.key == key) {
                node.next = node.next!!.next
            }
            node = node.next!!
        }
    }
}

class Node constructor(val key: Int = -1, val value: Int = -1, var next: Node? = null)
