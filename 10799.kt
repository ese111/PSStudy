import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun vps(input: String): Int {
    val stack = Stack<Char>()
    var cnt = 0
    for (j in 0 until input.length) {
        when (input[j] == '(') {
            true -> {
                stack.push(input[j])
            }
            false -> {
                stack.pop()
                if(input[j-1] == '(') {
                    cnt += stack.size
                } else {
                    cnt++
                }
            }
        }
    }
    return cnt
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()

    val bw = System.out.bufferedWriter()

    bw.write("".plus(vps(input)))

    bw.flush()
    bw.close()
    br.close()
}