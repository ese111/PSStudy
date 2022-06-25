import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.StringTokenizer

private fun solution(list: IntArray): Int? {
    val n = list.size
    
    val dp = list.copyOf()
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (list[j] < list[i]) {
                dp[i] = maxOf(dp[i], dp[j]+list[i])
            }
        }
    }
    
    return dp.maxOrNull()
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = StringTokenizer(br.readLine()).run { IntArray(n){nextToken().toInt()} }
    

    println(solution(list))
}