import java.io.BufferedReader
import java.io.InputStreamReader

private fun parallel(n: Int): StringBuilder {
    val sb = StringBuilder()
    var x = n
    if(n <= 1) {
        return sb
    }

    var i = 2
    while (i * i <= x) {
        while (x % i == 0) {
            sb.append("$i \n")
            x /= i
        }
        i++
    }
    if (x > 1) {
        sb.append("$x")
    }
    return sb
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    bw.write(parallel(n).toString())


    bw.flush()
    bw.close()
    br.close()
}
