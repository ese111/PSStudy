import java.io.BufferedReader
import java.io.InputStreamReader

var count = 0

fun blockChecker(map: Array<IntArray>, list: List<Int>) {
    for (i in list[1] until list[3]) {
        for (j in list[0] until list[2]) {
            map[i][j] = 1
        }
    }
}

fun areaDfs(map: Array<IntArray>, x: Int, y: Int, M: Int, N: Int) {
    map[y][x] = 1
    count++
    if (M > y+1 && map[y + 1][x] == 0) {
        areaDfs(map, x, y + 1,M, N)
    }
    if (y-1 >= 0 && map[y - 1][x] == 0) {
        areaDfs(map, x, y - 1,M, N)
    }
    if (N > x+1 && map[y][x + 1] == 0) {
        areaDfs(map, x + 1, y, M, N)
    }
    if (x-1 >= 0 && map[y][x - 1] == 0) {
        areaDfs(map, x - 1, y, M, N)
    }
}

fun areaCalculate(
    map: Array<IntArray>,
    M: Int,
    N: Int
): List<Int> {
    val list = mutableListOf<Int>()

    for(i in 0 until M) {
        for(j in 0 until N) {
            if (map[i][j] == 0) {
                count = 0
                areaDfs(map, j, i, M, N)
                list.add(count)
            }
        }
    }
    list.sort()
    return list
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (M, N, K) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(M) { IntArray(N) }

    for (i in 0 until K) {
        val arr = br.readLine().split(" ").map { it.toInt() }
        blockChecker(map, arr)
    }
    val list = areaCalculate(map, M, N)

    val n = list.size
    println(n)
    for(i in 0 until n) {
        if(i != 0) {
            print(" ")
        }
        print(list[i])
    }
}