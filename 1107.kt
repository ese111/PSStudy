package com.example.codingtest

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min


private fun Int.size(): Int {
    var cnt = 1
    var x = this
    while (x / 10 > 0) {
        x /= 10
        cnt++
    }
    return cnt
}

private fun check(num: Int, brokenButtons: IntArray): Boolean {
    brokenButtons.forEach {
        if(it.toString() in num.toString()) {
            return false
        }
    }
    return true
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().trim().toInt()

    val m = br.readLine().toInt()

    val numbers = if (m != 0) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    } else {
        intArrayOf(-1)
    }

    if (n == 100) {
        bw.write("0")
        bw.flush()
        bw.close()
        return
    }

    val num = if (n - 100 < 0) {
        (n - 100) * -1
    } else {
        n - 100
    }

    val size = n.size()

    if (size > num || m == 10) {
        bw.write(num.toString())
        bw.flush()
        bw.close()
    } else {
        var upChannel = n
        var downChannel = n
        var cnt = 0
        while (true) {
            val up = check(upChannel, numbers)
            val down = check(downChannel, numbers)
            if (up || down && downChannel >= 0 ) {
                val digit = if(up && !down) {
                    upChannel.size()
                } else {
                    downChannel.size()
                }
                val total = digit + cnt
                val answer = min(total, num)
                
                bw.write(answer.toString())
                bw.flush()
                bw.close()
                return
            } else {
                downChannel--
                upChannel++
                cnt++
            }
        }
    }
}