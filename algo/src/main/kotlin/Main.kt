fun main(args: Array<String>) {
    testingHashMap()
}

private fun testingHashMap() {
    println("testingMap")

    val map = hash.MyHashMap()
    map.put(1, 1)
    map.put(2, 2)
    println("$map")

    var data = map.get(1)
    println("data of key 1: $data")
    data = map.get(-1)
    println("data of key -1: $data")
    map.put(2, 1)
    println("$map")
    data = map.get(2)
    println("data of key 2: $data")
    println("remove 2")
    map.remove(2)
    data = map.get(2)
    println("data of key 2: $data")
}