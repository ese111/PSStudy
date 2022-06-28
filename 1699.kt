import java.io.BufferedReader
import java.io.InputStreamReader

private fun setDp(n: Int): IntArray {

    val dp = IntArray(n + 1)
    var j = 1
    for ( i in 0..n) {
        dp[i] = i
        while (j * j <= i ) {
            dp[i] = minOf(dp[i - j * j] + 1, dp[i])
            j++
        }
        j = 1
    }
    return dp
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = setDp(n)

    println(dp[n])
}