import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.pow

private fun converter(x: Int, digit: Int): Stack<Int> {
    val stack = Stack<Int>()
    var num = x
    if (x == 0) {
        stack.push(0)
        return stack
    }
    while (num != 0) {
        val r = num % digit
        stack.push(r)
        num /= digit
    }

    return stack
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    val num = br.readLine().split(" ").map { it.toInt() }
    val n = num.size - 1
    var x = num[n]
    for (i in 0 until n) {
        x += num[i] * a.toDouble().pow(n - i).toInt()
    }
    val stack = converter(x, b)
    val sb = StringBuilder()
    for (i in 0 until stack.size) {
        sb.append(stack.pop()).append(" ")
    }
    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}