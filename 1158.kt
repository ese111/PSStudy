import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun josephus(list: List<Int>): StringBuilder {
    val deque = ArrayDeque<Int>()

    for (i in 1 .. list[0]) {
        deque.addLast(i)
    }
    val sb = StringBuilder()
    sb.append("<")
    while (!deque.isEmpty()) {
        for (i in 0 until list[1]) {
            val kill = deque.pollFirst()
            if (i == list[1] - 1) {
                sb.append(kill)
                if(deque.size != 0) {
                    sb.append(", ")
                }
            } else {
                deque.addLast(kill)
            }
        }
    }
    sb.append(">")
    return sb
}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    val list = br.readLine().split(" ").map { it.toInt() }

    bw.write("".plus(josephus(list)))

    bw.flush()
    bw.close()
    br.close()
}