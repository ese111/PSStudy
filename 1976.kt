package com.example.codingtest

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    parent = IntArray(n + 1) { i -> i }

    repeat(n) { i ->

        val input = br.readLine().split(" ").map { it.toInt() }

        input.forEachIndexed { j, int ->
            if (int == 1) {
                union(i, j)
            }
        }
    }

    val plan = br.readLine().split(" ").map { it.toInt() }

    for (i in 1 until plan.size) {
        if (!isContains(plan[i - 1] - 1, plan[i] - 1)) {
            println("NO")
            return
        }
    }
    
    println("YES")
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