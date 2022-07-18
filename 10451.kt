import java.io.BufferedReader
import java.io.InputStreamReader

private var cnt = 0

private fun dfs(index: Int, start: Int, map: List<Int>, visited: BooleanArray) {
    visited[index] = true
    if (map[index] - 1 == start) {
        cnt++
        return
    }
    if (!visited[map[index] - 1]) {
        dfs(map[index] - 1, start, map, visited)
    }

}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val nodes = br.readLine().split(" ").map { it.toInt() }

        val visited = BooleanArray(n)
        cnt = 0
        for (i in 0 until n) {
            if (!visited[i]) {
                dfs(i, i, nodes, visited)
            }
        }

        bw.write("$cnt")
        bw.write("\n")
    }

    bw.flush()
    bw.close()
    br.close()
}
