import java.io.BufferedReader
import java.io.InputStreamReader

private fun gcd(a: Long, b: Long): Long {
    var x = a
    var y = b

    while (y != 0L) {
        val r = x % y
        x = y
        y = r
    }
    return x
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val sb = StringBuilder()

    val (a, b) = br.readLine().split(" ").map { it.toLong() }

    val result = gcd(a, b)
    for (i in 0 until result) {
        sb.append(1)
    }
    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}