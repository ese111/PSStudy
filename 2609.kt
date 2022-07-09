import java.io.BufferedReader
import java.io.InputStreamReader

fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val r = x % y

        x = y
        y = r
    }
    return x
}

fun lcm(a: Int, b: Int, gcd: Int) = a * b / gcd

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    val sb = StringBuilder()
    val g = gcd(a, b)
    val l = lcm(a, b, g)
    sb.append("".plus(g))
    sb.append("\n".plus(l))
    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}