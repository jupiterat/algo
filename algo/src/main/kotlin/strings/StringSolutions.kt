package strings

class StringSolutions {
    companion object {
        /**
         * Add binary
         *
         * Time Complexity O(max(N,M)) : Where N and M are lengths of input string.
         * As we are traversing both the string linearly in a single loop, time complexity will be equal to maximum length out of the two input strings .
         *
         * Space Complexity O(max(N,M)) :
         * For storing the result in a string after addition we need string whose size is equal to max of length of the input strings .
         */
        fun addBinary(a: String, b: String): String {
            var i = a.length - 1
            var j = b.length - 1
            val result = StringBuilder()
            var carry = 0

            while (i >= 0 || j >= 0) {
                var sum = carry

                if (i >= 0) {
                    sum += a[i] - '0'
                    i--
                }
                if (j >= 0) {
                    sum += b[j] - '0'
                    j--
                }
                result.insert(0, sum % 2)

                carry = sum / 2
            }

            if (carry > 0) {
                result.insert(0, carry)
            }

            return result.toString()
        }


        /**
         * Implement strStr()
         * indexOf in java
         */

        fun strStr(haystack: String, needle: String): Int {
            if (haystack == needle) {
                return 0
            }

            val needleLength = needle.length
            for (index in 0 until haystack.length + 1 - needleLength) {
                if (haystack.substring(index, index + needleLength) == needle) {
                    return index
                }
            }

            return -1
        }

    }
}