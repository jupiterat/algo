package array

import kotlin.math.max

class ArraySolutions {
    companion object {
        /**
         * Given a binary array nums, return the maximum number of consecutive 1's in the array.
         */
        fun findMaxConsecutiveOnes(nums: IntArray): Int {
            var result = 0
            var length = 0
            for (i in nums) {
                println("index: $i")
                if (i == 1) {
                    length++
                    result = max(result, length)
                } else {
                    length = 0
                }
            }
            return result
        }
    }

}