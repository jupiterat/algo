package companies

import kotlin.math.abs

class Google {
    companion object {
        fun sortedSquares(nums: IntArray): IntArray {
            var l = 0
            var r = nums.size - 1
            var index = nums.size - 1
            val result = IntArray(nums.size)

            while (l <= r) {
                if (abs(nums[l]) > abs(nums[r])) {
                    result[index] = nums[l] * nums[l]
                    index--
                    l++
                } else {
                    result[index] = nums[r] * nums[r]
                    index--
                    r--
                }
            }
            return result
        }
    }
}