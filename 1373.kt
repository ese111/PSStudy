import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val n = br.readLine()

    bw.write(n.toBigInteger(2).toString(8))

    bw.flush()
    bw.close()
    br.close()
}