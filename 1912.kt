import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private fun setDp(list: IntArray): IntArray {
    val n = list.size

    val dp = IntArray(n)
    dp[0] = list[0]

    for (i in 1 until n) {
        println("i = $i  dp[i] = ${dp[i]}, list[i] = ${list[i]}, dp[i - 1] + list[i] = ${dp[i - 1] + list[i]}, dp[i -1] = ${dp[i - 1]}")
        dp[i] = maxOf(dp[i - 1] + list[i], list[i])
    }

    return dp
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    val dp = setDp(list)

    println(dp.maxOrNull())
}