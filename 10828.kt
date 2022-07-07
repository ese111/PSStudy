import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

class Stack {
    data class Node(
        val value: Int,
        var pre: Node? = null
    )

    private var cnt = 0

    private var last: Node? = null

    fun push(data: Int) {
        val item = Node(data)
        if (last != null) {
            item.pre = last
        }
        last = item
        cnt++
    }

    fun pop(): Int {
        val value = last?.value ?: -1
        last = last?.pre
        if(cnt != 0) {
            cnt--
        }
        return value
    }

    fun size() = cnt

    fun empty(): Int {
        return when (cnt) {
            0 -> 1
            else -> 0
        }
    }

    fun top(): Int {
        return last?.value ?: -1
    }
}


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stack = Stack()

    val bw = System.out.bufferedWriter()

    for (i in 0 until n) {
        val input = br.readLine().split(" ")

        when (input[0]) {
            "push" -> {
                stack.push(input[1].toInt())
            }
            "pop" -> {
                bw.write("".plus(stack.pop()))
                bw.write("\n")
            }
            "size" -> {
                bw.write("".plus(stack.size()))
                bw.write("\n")
            }
            "empty" -> {
                bw.write("".plus(stack.empty()))
                bw.write("\n")
            }
            "top" -> {
                bw.write("".plus(stack.top()))
                bw.write("\n")
            }
        }

    }

    bw.flush()
    bw.close()
    br.close()
}