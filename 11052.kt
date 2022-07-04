import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private fun setDp(list: List<Int>) {
    val n = list.size
    val dp = IntArray(n + 1)
    dp[1] = list[0]
    for (i in 1..n ) {
        for (j in 1..i) {
            dp[i] = max(dp[i],dp[i-j]+list[j-1])
        }
    }
    println(dp[n])
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }

    val dp = setDp(list)
}


