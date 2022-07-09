import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

private fun isPrime(n: Int): Boolean {
    if(n == 1) {
        return false
    }

    var i = 2
    while (i * i <= n) {
        if(n % i++ == 0) {
            return false
        }
    }

    return true
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val list = br.readLine().split(" ").map { it.toInt() }
    var cnt = 0
    for (i in 0 until n) {
        if(isPrime(list[i])) {
            cnt++
        }
    }
    bw.write(cnt.toString())
    bw.flush()
    bw.close()
    br.close()
}