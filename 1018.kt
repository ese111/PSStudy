import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private fun find(i: Int, j: Int, pan: Array<BooleanArray>): Int {
    var firstWhite = 0
    var firstBlack = 0
    for (k in i until i + 8) {
        for (g in j until j + 8) {
            if((k + g) % 2 == 0) {
                if(pan[k][g]) {
                    firstWhite++
                } else {
                    firstBlack++
                }
            } else {
                if(!pan[k][g]) {
                    firstWhite++
                } else {
                    firstBlack++
                }
            }
        }
    }
    return min(firstWhite, firstBlack)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val pan = Array(N) { BooleanArray(M) }
    val count = mutableListOf<Int>()

    for (i in 0 until N) {
        pan[i] = br.readLine().map { it == 'W'}.toBooleanArray()
    }

    for (i in 0 until N-7) {
        for (j in 0 until M-7) {
            count.add(find(i, j, pan))
        }
    }
    println(count.minOrNull())
}