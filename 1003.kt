import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun getDp(): Array<IntArray> {
    val dp = Array(41) { IntArray(2) }
    dp[0] = intArrayOf(1, 0)
    dp[1] = intArrayOf(0, 1)

    for (i in 2..40) {
        dp[i] = intArrayOf(dp[i - 1][1], dp[i-1][0] + dp[i-1][1])
    }
    return dp
}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val list = mutableListOf<Int>()
    for (i in 0 until t) {
        list.add(br.readLine().toInt())
    }
    val dp = getDp()

    list.forEach {
        println("${dp[it][0]} ${dp[it][1]}")
    }

}