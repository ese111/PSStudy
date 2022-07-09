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

    val n = br.readLine().toInt()

    for (i in 0 until n) {
        val list = br.readLine().split(" ").map { it.toLong() }
        var x = 0L
        val len = list[0].toInt()
        for (j in 1 until len) {
            for (k in j + 1 .. len) {
                x += gcd(list[j], list[k])
            }
        }
        sb.append(x)
        sb.append("\n")
    }

    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}