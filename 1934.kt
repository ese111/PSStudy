import java.io.BufferedReader
import java.io.InputStreamReader

fun gcd(a: Int, b: Int): Int {
    if(b == 0) {
        return a
    }
    return gcd(b, a % b)
}

fun lcm(a: Int, b: Int, gcd: Int) = a * b / gcd

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    val sb = StringBuilder()

    for (i in 1..n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val g = gcd(a, b)
        val l = lcm(a, b, g)

        sb.append("".plus(l))
        sb.append("\n")
    }

    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}