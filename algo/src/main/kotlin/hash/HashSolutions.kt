package hash

import java.util.Collections.frequency
import java.util.logging.Logger
import javax.swing.text.html.HTML.Attribute.N


class HashSolutions {
    /**
     * Contains Duplicate
     */
    companion object {
        fun containsDuplicate(nums: IntArray): Boolean {
            val set = HashSet<Int>()
            for (item in nums) {
                if (set.contains(item)) {
                    return true
                }
                set.add(item)
            }
            return false
        }

        /**
         * Valid Anagram
         */
        fun isAnagram(s: String, t: String): Boolean {
            if(s.length != t.length) {
                return  false
            }
            val countS = HashMap<String, Int>()
            val countT = HashMap<String, Int>()

            for (i in s.indices) {
                countS[s[i].toString()] = 1 + (countS[s[i].toString()] ?: 0)
                countT[t[i].toString()] = 1 + (countT[t[i].toString()] ?: 0)
            }

            for (c in countS.keys) {
                if(countS[c] != (countT[c] ?: 0)) {
                    return false
                }
            }
            return true
        }

        fun isAnagram1(s: String, t: String): Boolean {
            if (s.length != t.length) return false
            val store = IntArray(26)
            for (i in s.indices) {
                store[s[i] - 'a']++
                store[t[i] - 'a']--
            }
            for (n in store) if (n != 0) return false
            return true
        }

        /**
         * not require sorted array
         */
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val preMap = HashMap<Int, Int>()

            for (index in nums.indices) {
                val diff = target - nums[index]
                if(preMap.contains(diff)) {
                    return intArrayOf(preMap[diff]!!, index)
                }
                preMap[nums[index]] = index
            }
            return intArrayOf(-1, -1)
        }

        /**
         * Group Anagrams
         */
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val res: MutableList<List<String>> = ArrayList()
            if (strs.isEmpty()) return res
            val map = HashMap<String, MutableList<String>>()
            for (s in strs) {
                val hash = CharArray(26)
                for (c in s) {
                    hash[c - 'a']++
                }
                val key = String(hash)
                map.computeIfAbsent(key) { ArrayList() }
                map[key]!!.add(s)
            }
            res.addAll(map.values)
            return res
        }

        /**
         * Top K Frequent Elements
         */
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            /**
             * Create a HashMap count and store the count of the elements in the given array.
             * Create a 2D vector frequency of size N + 1 to store the elements according to their frequencies.
             * Now initialize a variable count = 0.
             * While count < K: Traverse the frequency vector from N till 0 and print the elements present in the vector and increment the count for each element.
             */
            val count = HashMap<Int, Int>()
            val freq = arrayListOf<ArrayList<Int>>()

            for (num in nums) {
                count[num] = 1 + (count[num] ?: 0)
            }

            for (i in 0 until nums.size + 1) {
                freq.add(arrayListOf())
            }

            for (item in count.entries) {
                freq[item.value].add(item.key)
            }
            val result = arrayListOf<Int>()
            for (i in freq.size - 1 downTo  0) {
                for (item in freq[i]) {
                    result.add(item)
                    if(result.size == k) {
                        return result.toIntArray()
                    }
                }
            }

            return result.toIntArray()
        }

        /**
         * valid sudoku
         */
        fun isValidSudoku(board: Array<CharArray>): Boolean {
            //UN_COMPLETED
            val rows = hashSetOf<Char>()
            val cols = hashSetOf<Char>()
            val squares = hashSetOf<Char>()
            for (r in 0 until 9) {
                for(c in 0 until 9) {
//                    print("board[" + r + "][" + c + "]:" + board[r][c] + " ")
                    print(board[r][c] + " | ")
                    if(board[r][c] == '.') {
                        continue
                    }
                    if(rows.contains(board[r][c]) ||
                        rows.contains(board[r][c])) {
                        return false
                    }
                    rows.add(board[r][c])
                    cols.add(board[r][c])
                }
                println()
            }
            return true
        }
    }
}