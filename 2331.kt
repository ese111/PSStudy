import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

private fun dfs(index: Int, p: Int, visited: IntArray) {
    visited[index]++
    if (visited[index] > 2) {
        return
    }
    dfs(cal(index, p), p, visited)
}

private fun cal(a: Int, p: Int): Int {
    var k = a
    var sum = 0
    while (k > 0) {
        sum += (k % 10).toDouble().pow(p.toDouble()).toInt()
        k /= 10
    }
    return sum
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val visited = IntArray(100000)
    val (a, p) = br.readLine().split(" ").map { it.toInt() }

    dfs(a, p, visited)

    var cnt = 0
    visited.forEach {
        if (it == 1) {
            cnt++
        }
    }
    bw.write("$cnt")
    bw.flush()
    bw.close()
    br.close()
}
