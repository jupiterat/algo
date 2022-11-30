package technique

import kotlin.math.max

class SlidingWindow {
    companion object {
        fun maxProfit(prices: IntArray): Int {
            var l = 0
            var r = 1
            var maxP = 0
            while (r < prices.size) {
                if (prices[r] > prices[l]) {
                    val profit = prices[r] - prices[l]
                    maxP = max(maxP, profit)
                } else {
                    l = r
                }
                r++
            }
            return maxP
        }

        /**
         * Longest Substring Without Repeating Characters
         */
        fun lengthOfLongestSubstring(s: String): Int {
            var result = 0
            val charSet = hashSetOf<Char>()
            var l = 0
            for (r in s.indices) {
                println("before l: $l r: $r")

                while (charSet.contains(s[r])) {
                    charSet.remove(s[l])
                    l++
                }
                charSet.add(s[r])
                //r - l + 1: current window size
                result = max(result, r - l + 1)
                println("after l: $l r: $r")
            }
            return result
        }

        /**
         * Permutation in String
         * O(26*n)
         */
        fun checkInclusion(s1: String, s2: String): Boolean {
            if (s1.length > s2.length) {
                return false
            }
            val s1Data = IntArray(26)
            val s2Data = IntArray(26)

            for (i in s1.indices) {
                s1Data[s1[i] - 'a']++
                s2Data[s2[i] - 'a']++
            }
            var windowStart = 0
            var windowEnd = s1.length

            while (windowEnd < s2.length) {
                if (matches(s1Data, s2Data)) {
                    return true
                }
                s2Data[s2[windowEnd] - 'a']++
                s2Data[s2[windowStart] - 'a']--
                windowStart++
                windowEnd++
            }
            return matches(s1Data, s2Data)
        }

        fun matches(s1Data: IntArray, s2Data: IntArray): Boolean {
            for (i in 0..25) {
                if (s1Data[i] != s2Data[i]) {
                    return false
                }
            }
            return true
        }

        /**
         *  Longest Repeating Character Replacement
         */
        fun characterReplacement(s: String, k: Int): Int {
            var result = 0
            var maxCount = 0
            var l = 0
            var r = 0

            while (r < s.length) {

                r++
            }

            return result

//            var result = 0
//            var maxCount = 0
//            var l = 0
//            var r = 0
//            val map = IntArray(26) { 0 }
//
//            while (r < s.length) {
//                map[s[r] - 'A']++
//                maxCount = max(maxCount, map[s[r] - 'A'])
//                while (r - l + 1 - maxCount > k) {
//                    map[s[l] - 'A']--
//                    l++
//                }
//                result = max(result, r - l + 1)
//                r++
//            }
//            return result
        }
    }
}