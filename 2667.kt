
private var cnt = 0

private fun dfs(visited: Array<BooleanArray>, arr: Array<IntArray>, x: Int, y:Int) {
    visited[x][y] = true
    cnt++

    if(arr[x+1][y] == 1 && !visited[x+1][y]){
        dfs(visited, arr, x+1, y)
    }
    if(arr[x][y+1] == 1 && !visited[x][y+1]){
        dfs(visited, arr, x,y+1)
    }
    if(arr[x-1][y] == 1 && !visited[x-1][y]){
        dfs(visited, arr, x-1,y)
    }
    if(arr[x][y-1] == 1 && !visited[x][y-1]){
        dfs(visited, arr, x,y-1)
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val map = Array(n + 2){IntArray(n + 2){0} }
    val visited = Array(n + 2) { BooleanArray(n + 2) }

    for (i in 1..n) {
        val line = br.readLine().split("").filter { it.isNotBlank() }.map { it.toInt() }
        line.forEachIndexed { index, num ->
            map[i][index + 1] = num
        }
    }

    val answer = mutableListOf<Int>()
    for(i in 1 .. n){
        for(j in 1 .. n){
            if(map[i][j] == 1 && !visited[i][j]){
                dfs(visited, map, i, j)
                answer.add(cnt)
                cnt = 0
            }
        }
    }

    bw.write("${answer.size}\n")
    answer.sort()
    answer.forEach { i -> bw.write("$i\n") }

    bw.flush()
    br.close()
    bw.close()
}
