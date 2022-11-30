package technique

import java.util.*

class Stack {
    companion object {
        /**
         * Valid Parentheses
         * {}[]()
         */
        fun isValid(s: String): Boolean {
            val openToClose = hashMapOf("}" to "{", "]" to "[", ")" to "(")
            val stack = ArrayDeque<String>()

            for (c in s) {
                //if c is closing bracket...
                if (openToClose.contains(c.toString())) {
                    //check peek of stack
                    if (stack.isNotEmpty() && stack.peek() == openToClose[c.toString()]) {
                        stack.pop()
                    } else {
                        return false
                    }
                } else {
                    stack.push(c.toString())
                }
            }
            return stack.isEmpty()
        }

        /**
         * Evaluate Reverse Polish Notation
         */
        fun evalRPN(tokens: Array<String>): Int {
            val stack = ArrayDeque<Int>()
            for (c in tokens) {
                when (c) {
                    "+" -> {
                        stack.push(stack.pop() + stack.pop())
                    }
                    "*" -> {
                        stack.push(stack.pop() * stack.pop())
                    }
                    "-" -> {
                        val a = stack.pop()
                        val b = stack.pop()
                        stack.push(b - a)
                    }
                    "/" -> {
                        val a = stack.pop()
                        val b = stack.pop()
                        stack.push(b / a)
                    }
                    else -> {
                        stack.push(c.toInt())
                    }
                }
            }

            return stack.peek()
        }

    }
}

class MinStack() {
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        val min = `val`.coerceAtMost(if (minStack.isEmpty()) minStack.peek() else `val`)
        minStack.push(min)
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}