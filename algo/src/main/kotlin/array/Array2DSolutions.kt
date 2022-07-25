package array

class Array2DSolutions {
    companion object {
        /**
         * Diagonal Traverse
         *
         * 
         * Time Complexity:
         * O(N⋅M) since we process each element of the matrix exactly once.
         * Space Complexity:
         * O(1) since we don't make use of any additional data structure.
         * Note that the space occupied by the output array doesn't count towards the space complexity since that is a requirement of the problem itself.
         * Space complexity comprises any additional space that we may have used to get to build the final array.
         * For the previous solution, it was the intermediate arrays. In this solution, we don't have any additional space apart from a couple of variables.
         *
         */

        fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
            if (mat.isEmpty()) {
                return IntArray(0)
            }

            val N = mat.size
            val M = mat[0].size

            var row = 0
            var column = 0

            var direction = 1
            val result = IntArray(M * N)
            var k = 0
            while (row < N && column < M) {

                print("row: $row column: $column" )
                result[k] = mat[row][column]
                k++

                val new_row = row + (if (direction == 1) -1 else 1)
                val new_column = column + (if (direction == 1) 1 else -1)

                if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {
                    if (direction == 1) {
                        row += (if (column == M - 1) 1 else 0)
                        column += (if (column == M - 1) 0 else 1)
                    } else {
                        row += (if (row < N - 1) 1 else 0)
                        column += (if (row == N - 1) 1 else 0)
                    }

                    direction = 1 - direction
                } else {
                    row = new_row
                    column = new_column
                }
            }
            return result
        }

        /**
         * Diagonal Traverse
         * Time Complexity:
         * O(N*M) considering the array has N rows and M columns.
         * An important thing to remember is that for all the odd numbered diagonals, we will be processing the elements twice since we have to reverse the elements before adding to the result array.
         * Additionally, to save space, we have to clear the intermediate array before we process a new diagonal.
         * That operation also takes O(K) where K is the size of that array.
         * So, we will be processing all the elements of the array at least twice.
         * But, as far as the asymptotic complexity is concerned, it remains the same.
         *
         * Space Complexity:
         * O(min(N,M)) since the extra space is occupied by the intermediate arrays we use for storing diagonal elements and the maximum it can occupy is the equal to the minimum of N and M.
         * Remember, the diagonal can only extend till one of its indices goes out of scope.
         */
        fun findDiagonalOrder1(mat: Array<IntArray>): IntArray {
            if (mat.isEmpty()) {
                return IntArray(0)
            }

            val n = mat.size
            val m = mat[0].size
            val result = IntArray(m * n)
            val intermediate = arrayListOf<Int>()
            var k = 0

            for (d in 0 until m + n - 1) {
                intermediate.clear()
                var row = if (d < m) 0 else d - m + 1
                var col = if (d < m) d else m - 1

                while (row < n && col > -1) {
                    intermediate.add(mat[row][col])
                    row++
                    col--
                }
                if (d % 2 == 0) {
                    intermediate.reverse()
                }

                for (item in intermediate) {
                    result[k] = item
                    k++
                }

            }


            return result
        }
    }
}