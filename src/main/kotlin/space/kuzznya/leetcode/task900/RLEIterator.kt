package space.kuzznya.leetcode.task900

class RLEIterator(private val encoding: IntArray) {

    private var pos = 0
    private var groupUnpacked = false
    private var groupSize = 0
    private var groupValue = -1
    // groupSize & groupValue are valid only when groupUnpacked = true

    fun next(n: Int): Int {
        var left = n
        while (left > 0 && (pos < encoding.size || groupUnpacked)) {
            if (groupUnpacked && left > groupSize) {
                groupUnpacked = false
                left -= groupSize
//                println("Current group is smaller than required, skipping it, left $left")
            } else if (groupUnpacked && left == groupSize) {
                groupUnpacked = false
//                println("Group fully read, closing it and returning last value")
                return groupValue
            } else if (groupUnpacked && left < groupSize) {
                groupSize -= left
//                println("Group was not fully read, returning group value, $groupSize left in group")
                return groupValue
            }
            if (pos <= encoding.size - 2)
                unpack()
            else break
        }
        return -1
    }

    private fun unpack() {
        groupUnpacked = true
        groupSize = encoding[pos++]
        groupValue = encoding[pos++]
//        println("Unpacked group, len $groupSize, value $groupValue")
    }
}
