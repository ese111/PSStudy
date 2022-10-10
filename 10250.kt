import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun findRoom(h: Int, n: Int): String {
    val roomNumber = (n / h) + 1
    val floor = n % h
    if(floor == 0) {
        return getRoom(h, roomNumber - 1)
    }
    return getRoom(floor, roomNumber)
}

private fun getRoom(floor: Int, num: Int): String {
    return if(num > 9) {
        "${floor}$num"
    } else {
        "${floor}0$num"
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    for (i in 0 until t) {
        val (h, w, n) = br.readLine().split(" ").map { it.toInt() }
        sb.append(findRoom(h, n))
        if(i != t - 1) {
            sb.append("\n")
        }
    }
    println(sb.toString())
}