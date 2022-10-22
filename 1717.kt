import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    parent = IntArray(n + 1) { i -> i }

    repeat(m) { i ->
        val (type, a, b) = br.readLine().split(" ").map { it.toInt() }
        if (type == 0) {
            union(a,b)
        } else {
            if (isContains(a, b)) println("YES")
            else println("NO")
        }
    }
}

private fun find(x: Int): Int {
    if (parent[x] == x) return x

    parent[x] = find(parent[x])

    return parent[x]
}

private fun union(x: Int, y: Int) {
    val findX = find(x)
    val findY = find(y)
    if (findX == findY) return
    if (parent[findY] < parent[findX]) parent[findX] = findY
    else parent[findY] = findX
}

private fun isContains(x: Int, y: Int): Boolean = find(x) == find(y)