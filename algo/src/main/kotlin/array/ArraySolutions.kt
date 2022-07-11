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

        /**
         * Duplicate Zeros
         */
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

        /**
         * Merge Sorted Array
         */
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

        /*
         *Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
         * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
         * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
         * It does not matter what you leave beyond the first k elements.
         * Return k after placing the final result in the first k slots of nums.
         * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
         *
         */
        fun removeElement(nums: IntArray, num: Int): Int {
            if (nums.isEmpty()) {
                return 0
            }
            var k = 0
            for (i in nums.indices) {
                if (nums[i] != num) {
                    nums[k] = nums[i]
                    k++
                }
            }
            return k
        }

        /**
         * Remove Duplicates from Sorted Array
         */
        fun removeDuplicates(nums: IntArray): Int {
            var j = 0
            for (i in 0 until nums.size - 1) {
                if (nums[i] != nums[i + 1]) {
                    println("i: $i value: ${nums[i]},")
                    nums[j] = nums[i]
                    j++
                }
            }
            // Store the last element as whether it is unique or repeated, it hasn't stored previously
            nums[j++] = nums[nums.size - 1]
            return j
        }

        /**
         * Check If N and Its Double Exist
         * Time complexity : O(n) For each element, we try to find its match in the Set object by looping through the array which takes O(n) time.
         * O(nlogn) in case of collision(TreeMap) - with LinkedListMap, collisions are rare so O(1) -> O(n)
         * Space complexity : O(n) The space complexity is O(n) because it needs a variable newSet to store the data.
         */
        fun checkIfExist(arr: IntArray): Boolean {
            val set = HashSet<Int>()
            for (i in arr.indices) {
                val value = arr[i]
                if (set.contains(value)) {
                    print("value at index $i is $value")
                    return true
                }
                set.add(value * 2)
                if (value % 2 == 0) {
                    //ignore if it is odd {3, 1, 7, 11}
                    set.add(value / 2)
                }
            }
            return false
        }

        /**
         * Valid Mountain Array
         * Time Complexity: O(n)
         * Space Complexity: O(1)
         */
        fun validMountainArray(arr: IntArray): Boolean {
            var j = 0
            val size = arr.size
            while (j + 1 < size && arr[j] < arr[j + 1]) {
                // walk up
                println("i1: $j: ${arr[j]} - ${arr[j + 1]}")
                j++
            }

            if (j == 0 || j == size - 1) {
                return false
            }
            while (j + 1 < size && arr[j] > arr[j + 1]) {
                println("i2: $j: ${arr[j]} - ${arr[j + 1]}")
                j++
            }

            return j == size - 1
        }

        /**
         * Replace Elements with Greatest Element on Right Side
         */
        fun replaceElements(arr: IntArray): IntArray {
//            if (arr.size == 1) {
//                arr[0] = -1
//            }
//
//            for (i in arr.indices) {
//                if (i < arr.size - 1) {
//                    var max = arr[i + 1]
//                    for (j in i + 1 until arr.size) {
//                        if (arr[j] > max) {
//                            max = arr[j]
//                        }
//                    }
//                    arr[i] = max
//                } else {
//                    arr[i] = -1
//                }
//            }
//            return arr
            val size = arr.size
            var max_from_right = arr[size - 1]
            arr[size - 1] = -1
            for (i in size - 2 downTo 0) {
                val temp = arr[i]

                arr[i] = max_from_right
                println("a[${i}] is ${arr[i]}")
                if (temp > max_from_right) {
                    max_from_right = temp
                }
            }
            return arr

        }

        /**
         * Move Zeroes
         */
        fun moveZeroes(nums: IntArray): IntArray {
            var count = 0
            for (i in nums.indices) {
                if (nums[i] != 0) {
                    nums[count] = nums[i]
                    count++
                }
            }
            while (count < nums.size) {
                nums[count] = 0
                count++
            }
            return nums
        }

        /**
         * Find Pivot Index
         */
        fun pivotIndex(nums: IntArray): Int {
            var total = 0
            for (i in nums.indices) {
                total += nums[i]
            }
            var left_sum = 0
            for (i in nums.indices) {
                if (total - left_sum - nums[i] == left_sum) {
                    return i
                }
                left_sum += nums[i]
            }
            return -1
        }

        /**
         * Largest Number At Least Twice of Others
         */
        fun dominantIndex(nums: IntArray): Int {
            var maximumIndex = 0
            for (i in nums.indices) {
                if (nums[i] > nums[maximumIndex]) {
                    maximumIndex = i
                }
            }
            //
            for (i in nums.indices) {
                if (i != maximumIndex && nums[i] * 2 > nums[maximumIndex]) {
                    return -1
                }
            }
            return maximumIndex
        }

        /**
         * Plus One
         */
        fun plusOne(digits: IntArray): IntArray {
            for (i in digits.size - 1 downTo 0) {
                if(digits[i] != 9) {
                    digits[i]++
                    return digits
                }
                //all 9 -> 0 then add new item
                digits[i] = 0
            }
            val result = IntArray(digits.size + 1)
            System.arraycopy(digits, 0, result, 1, digits.size)
            result[0] = 1
            return result
        }
    }

}