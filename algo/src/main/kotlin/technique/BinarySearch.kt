package technique

import kotlin.math.ceil
import kotlin.math.min

class BinarySearch {
    companion object {
        /**
         * Binary Search
         *
         * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
         * You must write an algorithm with O(log n) runtime complexity.
         */
        fun search(nums: IntArray, target: Int): Int {
            var l = 0
            var r = nums.size - 1
            while (l <= r) {
                val mid = (l + r) / 2
                if (nums[mid] < target) {
                    l = mid + 1
                } else if (nums[mid] > target) {
                    r = mid - 1
                } else {
                    return mid
                }
            }
            return -1
        }

        /**
         * Search a 2D Matrix
         */
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            var top = 0
            var bottom = matrix.size - 1

            while (top <= bottom) {
                val row = (top + bottom) / 2

                val lastIndex = matrix[row].size - 1
                if (matrix[row][lastIndex] < target) {
                    top = row + 1
                } else if (matrix[row][0] > target) {
                    bottom = row - 1
                } else {
                    break
                }
            }

            if (top > bottom) {
                return false
            }
            val row = (top + bottom) / 2
            var l = 0
            var r = matrix[row].size - 1

            while (l <= r) {
                val mid = (l + r) / 2
                if (matrix[row][mid] < target) {
                    l = mid + 1
                } else if (matrix[row][mid] > target) {
                    r = mid - 1
                } else {
                    return true
                }
            }
            return false
        }

        /**
         * Koko Eating Bananas
         */
        fun minEatingSpeed(piles: IntArray, h: Int): Int {
            var l = 1 //minimum [1....max(piles)]
            var r = 0
            for (element in piles) {
                r = maxOf(r, element)
            }
            var result = r
            while (l <= r) {
                val k = (l + r) / 2
                var hours = 0.0
                for (item in piles) {
                    hours += ceil(item.toDouble() / k)
                }
                if (hours <= h) {
                    result = min(result, k)
                    r = k - 1
                } else {
                    l = k + 1
                }
            }
            return result
        }
    }
}