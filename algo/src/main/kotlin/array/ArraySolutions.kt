package array

import kotlin.math.abs
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

        fun findNumbers(nums: IntArray): Int {
            var count = 0
            for (i in nums) {
                if (i.toString().length % 2 == 0) {
                    count++
                }
            }
            return count
        }

        /**
         * Squares of a Sorted Array
         */
        fun sortedSquares(nums: IntArray): IntArray {
            val size = nums.size
            var left = 0
            var right = size - 1
            val result = IntArray(size)

            for (i in size - 1 downTo 0) {
                if (abs(nums[left]) > abs(nums[right])) {
                    result[i] = nums[left] * nums[left]
                    left++
                } else {
                    result[i] = nums[right] * nums[right]
                    right--
                }
            }
            return result
        }
    }

}