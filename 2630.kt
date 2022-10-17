import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var blue = 0
private var white = 0

private fun check(map: Array<IntArray>, n: Int, x: Int, y: Int): Boolean {
    val now = map[y][x]
    for (i in y until n + y) {
        for (j in x until n + x) {
            if(map[i][j] != now) {
                return false
            }
        }
    }
    return true
}

private fun count(paper: Int) = when (paper) {
    0 -> white++
    else -> blue++
}

private fun countPaper(map: Array<IntArray>, n: Int, x: Int, y: Int) {
    if (n == 1) {
        count(map[y][x])
        return
    }
    if (!check(map, n, x, y)) {
        val new = n / 2
        countPaper(map, new, x, y)
        countPaper(map, new, x + new, y)
        countPaper(map, new, x, y + new)
        countPaper(map, new, x + new, y + new)
    } else {
        count(map[y][x])
        return
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val map = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        map[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    countPaper(map, n, 0, 0)

    println(white)
    println(blue)
}