package technique

import kotlin.math.max
import kotlin.math.min

class TwoPinterTechnique {
    companion object {
        /**
         * Reverse String
         */

        fun reverseString(s: CharArray): Unit {
            var i = 0
            var j = s.size - 1
            while (i < j) {
                val temp1 = s[i]
                s[i] = s[j]
                s[j] = temp1

                i++
                j--
            }
        }

        /**
         * for sorted array
         */
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            var start = 0
            var end = numbers.size - 1

            while (start <= end) {
                val sum = numbers[start] + numbers[end]
                if (sum > target) {
                    end--
                } else if (sum < target) {
                    start++
                } else {
                    return intArrayOf(start + 1, end + 1)
                }
            }

            return intArrayOf(-1, -1)
        }

        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()
            var result = arrayListOf<List<Int>>()
            for (i in nums.indices) {

                if(i > 0 && nums[i] == nums[i -1]) {
                    //second value must not be duplicated with the first one -3 -3 -1 -2 ....
                    continue
                }

                var j = i + 1
                var k = nums.size - 1

                while (j < k) {
                    var total = nums[i] + nums[j] + nums[k]
                    if(total == 0) {
                        result.add(arrayListOf(nums[i], nums[j], nums[k]))
                        j++
                        while (nums[j] == nums[j - 1] && j < k) {
                            j++
                        }
                    } else if (total > 0) {
                        k--
                    } else {
                        j++
                    }
                }

            }
            return result
        }

        /**
         * Container With Most Water
         */
        fun maxArea(height: IntArray): Int {
            var l = 0
            var r = height.size - 1
            var result = 0

            while(l < r) {
                val w = r - l
                val h = min(height[l], height[r])

                val area = w * h

                result = max(result, area)

                if(height[l] < height[r]) {
                    l++
                } else if(height[l] > height[r]) {
                    r--
                } else {
                    l++
                }
            }

            return result
        }

        /**
         * Valid Palindrome
         */
        fun isPalindrome(s: String): Boolean {
            var l = 0
            var r = s.length - 1
            while (l < r) {
                while (l < r && !isAlphanumeric(s[l])) {
                    l++
                }

                while (l < r && !isAlphanumeric(s[r])) {
                    r--
                }

                if (s[l].lowercase() != s[r].lowercase()) {
                    return false
                }
                l++
                r--
            }
            return true
        }

        private fun isAlphanumeric(c: Char): Boolean {
            return (c in 'a'..'z') || (c in '0'..'9') || (c in 'A'..'Z')
        }
    }
}