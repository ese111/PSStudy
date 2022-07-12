import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    sb.append(((n / 5) + (n / 25) + (n / 125)).toString())
    bw.write(sb.toString())

    bw.flush()
    bw.close()
    br.close()
}
