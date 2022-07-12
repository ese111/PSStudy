import java.io.BufferedReader
import java.io.InputStreamReader

private fun factorial(n: Int): Int {
    val sb = StringBuilder()
    if(n == 0) {
        return 1
    }

    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1
    for (i in 1..n) {
        dp[i] = i * dp[i-1]
    }
    return dp[n]
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    bw.write(factorial(n).toString())

    bw.flush()
    bw.close()
    br.close()
}
