import java.io.BufferedReader
import java.io.InputStreamReader

var tree: IntArray? = null

private fun init(start: Int, end: Int, node: Int): Int {
    if (start == end) {
        return 1.also { tree!![node] = it }
    }
    val mid = (start + end) / 2
    return (init(start, mid, 2 * node) + init(mid + 1, end, 2 * node + 1)).also { tree!![node] = it }
}

private fun update(start: Int, end: Int, node: Int, del: Int): Int {
    tree!![node]--
    return if (start == end) {
        0
    } else {
        val mid = (start + end) / 2
        if (del <= mid) {
            update(start, mid, 2 * node, del)
        } else {
            update(mid + 1, end, 2 * node + 1, del)
        }
    }
}

private fun query(start: Int, end: Int, node: Int, order: Int): Int {
    if (start == end) {
        return start
    }
    val mid = (start + end) / 2
    return if (order <= tree!![2 * node]) {
        query(start, mid, 2 * node, order)
    } else {
        query(mid + 1, end, 2 * node + 1, order - tree!![2 * node])
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    tree = IntArray(n * 4)
    init(1, n, 1)

    var index = 1
    val sb = StringBuilder("<")

    for (i in 0 until n) {
        index += k - 1
        val size: Int = n - i
        if (index % size == 0) {
            index = size
        } else if (index > size) {
            index %= size
        }

        val num = query(1, n, 1, index)

        update(1, n, 1, num)
        if (i == n - 1) {
            sb.append("$num>")
        } else {
            sb.append("$num, ")
        }
    }

    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}