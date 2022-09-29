import java.util.Stack

class Solution {
    fun solution(number: String, k: Int): String {
        val answer = StringBuilder()
        val stack: Stack<Char> = Stack()
        var n = k
        number.forEach {
            while (stack.isNotEmpty() && stack.peek() < it && n > 0 ) {
                stack.pop()
                n--
            }
            stack.push(it)
        
        }
        stack.forEach {
            answer.append(it)
        }
       
        return answer.toString()
    }
}