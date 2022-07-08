import java.io.BufferedReader
import java.io.InputStreamReader

class Queue() {

    data class Node(
        val value: Int,
        var next: Node? = null
        )
    private var first: Node? = null
    private var last: Node? = null
    private var cnt = 0

    fun push(value: Int) {
        val item = Node(value)
        if(last != null) {
            last?.next = item
        }
        last = item
        if(first == null) {
            first = last
        }
        cnt++
    }

    fun pop(): Int {
        val value = first?.value ?: -1
        first = first?.next

        if(cnt > 0) {
            cnt--
        }
        if(first == null) {
            last = null
        }
        return value
    }

    fun size() = cnt

    fun empty() = when(cnt == 0) {
        true -> 1
        false -> 0
    }

    fun front(): Int {
        return first?.value ?: -1
    }

    fun back(): Int {
        return last?.value ?: -1
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val bw = System.out.bufferedWriter()
    val queue = Queue()
    for (i in 0 until n) {
        val input = br.readLine().split(" ")

        when(input[0]) {
            "push" -> {
                queue.push(input[1].toInt())
            }

            "pop" -> {
                bw.write("".plus(queue.pop()))
                bw.write("\n")
            }

            "size" -> {
                bw.write("".plus(queue.size()))
                bw.write("\n")
            }

            "empty" -> {
                bw.write("".plus(queue.empty()))
                bw.write("\n")
            }

            "front" -> {
                bw.write("".plus(queue.front()))
                bw.write("\n")
            }

            "back" -> {
                bw.write("".plus(queue.back()))
                bw.write("\n")
            }
        }
    }

    bw.flush()
    bw.close()
    br.close()
}