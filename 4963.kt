package com.example.codingtest

private var cnt = 0

private fun dfs(visited: Array<BooleanArray>, arr: Array<IntArray>, x: Int, y:Int) {
    visited[x][y] = true

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
    if(arr[x-1][y-1] == 1 && !visited[x-1][y-1]) {
        dfs(visited,arr,x-1,y-1)
    }
    if(arr[x+1][y+1] == 1 && !visited[x+1][y+1]) {
        dfs(visited,arr,x+1,y+1)
    }
    if(arr[x-1][y+1] == 1 && !visited[x-1][y+1]) {
        dfs(visited,arr,x-1,y+1)
    }
    if(arr[x+1][y-1] == 1 && !visited[x+1][y-1]) {
        dfs(visited,arr,x+1,y-1)
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val answer = mutableListOf<Int>()
    while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        if(w == 0 && h == 0) {
            break
        }

        val map = Array(h){IntArray(w){0} }
        val visited = Array(h) { BooleanArray(w) }

        repeat (h) { i ->
            val line = br.readLine().split(" ").map { it.toInt() }
            line.forEachIndexed { index, num ->
                map[i][index] = num
            }
        }

        repeat(h) { i->
            repeat(w){ j->
                if(map[i][j] == 1 && !visited[i][j]){
                    dfs(visited, map, i, j)
                    cnt++
                }
            }
        }
        answer.add(cnt)
        cnt = 0
    }
    answer.forEach { i -> bw.write("$i\n") }
    bw.flush()
    br.close()
    bw.close()
}
