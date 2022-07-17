import java.util.*

class Solution {

    private fun checkSameString(size: Int, str: String): Int {
        var current = str.substring(0, size)
        var cnt = 0
        val length = str.length
        var next = length - size
        val sb = StringBuilder()
        var otherChar = 0
        for (i in size..str.length step size) {
            if (next - size >= 0) {
                next -= size
            }
            if (current == str.substring(i, length - next)) {
                cnt++
            } else {
                if (cnt == 0) {
                    sb.append(current)
                } else {
                    sb.append(cnt + 1).append(current)
                }
                cnt = 0
                current = str.substring(i, length - next)
            }
            otherChar = i
        }
        sb.append(otherChar(otherChar, length, str))
        return sb.toString().length
    }

    private fun otherChar(otherChar: Int, length: Int, str: String): String {
        var cnt = otherChar
        val sb = StringBuilder()
        if(otherChar != length) {
            for (i in 0 until  length - otherChar) {
                sb.append(str[cnt])
                cnt++
            }
        }
        return sb.toString()
    }

    fun solution(s: String): Int {
        val ans = s.length
        if (ans <= 1) {
            return ans
        }
        val result = IntArray(ans) { ans }

        for (i in 1..ans / 2) {
            result[i] = checkSameString(i, s)
        }
        return result.minOf { it }
    }
}

fun main() {
    val str = "xababcdcdababcdcd"
    println(Solution().solution(str))

}
