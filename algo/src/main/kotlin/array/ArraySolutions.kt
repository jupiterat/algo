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

        fun duplicateZeros(arr: IntArray): IntArray {
            //possible_dups: The count of possible_dups would give us the number of elements to be trimmed off the original array
            //length_ - possible_dups is the number of elements which would be included in the final array.
            var possible_dups = 0
            var length = arr.size - 1
            println("length: ${length} ")
            for (left in 0 until length + 1) {
                if (left > length - possible_dups) {
                    break
                }
                if (arr[left] == 0) {
                    if (left == length - possible_dups) {
                        arr[length] = 0
                        length -= 1
                        break
                    }
                    possible_dups++
                }
            }
            println("possible_dups: ${possible_dups} ")
            println("length after changed: ${length} ")

            val last = length - possible_dups
            for (i in last downTo 0) {
                if (arr[i] == 0) {
                    arr[i + possible_dups] = 0
                    possible_dups--
                    arr[i + possible_dups] = 0
                } else {
                    arr[i + possible_dups] = arr[i]
                }
            }
            return arr
        }

        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {

            var p1 = m - 1
            var p2 = n - 1
            var i = m + n - 1
            while (p2 >= 0) {
                if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                    nums1[i] = nums1[p1]
                    p1--
                } else {
                    nums1[i] = nums2[p2]
                    p2--
                }
                i--
            }

            return nums1
        }

        fun removeElement(nums: IntArray, num: Int): Int {
            if(nums.isEmpty()) {
                return 0
            }
            var k = 0
            for (i in 0 until nums.size) {
                if(nums[i] != num) {
                    nums[k] = nums[i]
                    k++
                }
            }
            return k
        }
    }

}