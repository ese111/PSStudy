import java.io.BufferedReader
import java.io.InputStreamReader

private fun setDp(n: Int, k: Int): Array<LongArray> {
    val dp = Array(k + 1){LongArray(n + 1){1} }

    for (i in 2..k ) {
        for (j in 1..n) {
            dp[i][j] = (dp[i-1][j] + dp[i][j - 1]) % 1000000000
        }
    }
    return dp 
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val dp = setDp(n,k)
    println(dp[k][n])
}


