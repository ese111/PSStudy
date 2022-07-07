import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun vps(input: String): String {
    val stack = Stack<Char>()
    
    for (j in 0 until input.length) {
        when (input[j] == '(') {
            true -> {
                stack.push(input[j])
            }
            false -> {
                if (!stack.empty()) {
                    stack.pop()
                } else {
                    return "NO"
                }
            }
        }
    }

    if (stack.empty()) {
        return "YES"
    } else {
        return "NO"
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val bw = System.out.bufferedWriter()

    for (i in 0 until n) {
        val input = br.readLine()

        bw.write(vps(input))
        bw.write("\n")
    }

    bw.flush()
    bw.close()
    br.close()
}