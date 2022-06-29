import java.io.BufferedReader
import java.io.InputStreamReader

private fun setDp(n: Int): IntArray {

    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[2] = 3
    for ( i in 4..n step(2)) {
        dp[i] += dp[i - 2] * 3
        for (j in 4..i step(2)) {
            dp[i] += dp[i - j] * 2
        }
    }
    return dp
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    if(n % 2 == 1) {
        println(0)
    } else {
        val dp = setDp(n)
        println(dp[n])
    }
}


