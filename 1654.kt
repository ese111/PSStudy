import java.io.BufferedReader
import java.io.InputStreamReader

private fun cut(myLan: LongArray, N : Int): Long {
    var min = 0L
    var max = myLan.maxOrNull() ?: 0L

    max++

    var mid = 0L

    while (min < max) {
        mid = (min + max) / 2

        var cnt = 0L

        myLan.forEach {
            cnt += it / mid
        }

        if (cnt < N) {
            max = mid
        } else {
            min = mid + 1
        }
    }
    
    return min - 1
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (K, N) = br.readLine().split(" ").map { it.toInt() }

    val myLan = LongArray(K)

    for (i in 0 until K) {
        myLan[i] = br.readLine().toLong()
    }
    
    println(cut(myLan, N))

}