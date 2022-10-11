import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.reflect.jvm.internal.impl.utils.DFS.Visited

private val dy = intArrayOf(-1, 1, 0, 0)
private val dx = intArrayOf(0, 0, 1, -1)
private var cnt = 0


private fun bfs(map: Array<BooleanArray>, visited: Array<BooleanArray>, x: Int, y: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(Pair(x, y))

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        for (i in 0 until 4) {
            val tmpY = dy[i] + now.second
            val tmpX = dx[i] + now.first
            if (tmpY in map.indices && tmpX in map[tmpY].indices && map[tmpY][tmpX] && !visited[tmpY][tmpX]) {
                visited[tmpY][tmpX] = true
                queue.offer(Pair(tmpX, tmpY))
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 테스트 케이스 개수 입력을 받는다
    val t = br.readLine().toInt()
    // m, n, k를 받는다
    for (i in 0 until t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        // 심어진 좌표를 받는다
        // 필드를 만든다
        val field = Array(n) { BooleanArray(m) }
        // 심어진 좌표는 true로 바꾼다
        for (j in 0 until k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            field[y][x] = true
        }

        val visited = Array(n) { BooleanArray(m) }
        // 필드를 돌면서 true면 상하좌우를 검사하고, false면 return
        // return할때마다 cnt++
        for (y in field.indices) {
            for (x in 0 until field[y].size) {
                if(field[y][x] && !visited[y][x]) {
                    bfs(field, visited, x, y)
                    cnt++
                }
            }
        }

        // cnt가 연결된 지역의 수 이므로 필요한 벌레의 수와 같다
        println(cnt)
        cnt = 0
    }
}