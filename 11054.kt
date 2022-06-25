import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private fun downProgression(list: IntArray): IntArray {
    val n = list.size

    val dp = IntArray(n) { 1 }
    for (i in n - 2 downTo  0) {
        for (j in n - 1 downTo i) {
            if (list[j] < list[i]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    return dp
}

private fun upProgression(list: IntArray): IntArray {
    val n = list.size

    val dp = IntArray(n) { 1 }
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (list[j] < list[i]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    return dp
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    val upDp = upProgression(list)
    val downDp = downProgression(list)
    val dp = IntArray(n)

    for (i in 0 until n) {
        dp[i] = upDp[i] + downDp[i]
    }

    println(dp.maxOrNull()?.minus(1))
}