package strings

class StringSolutions {
    companion object {
        /**
         * Add binary
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
    }
}