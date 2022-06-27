import java.io.BufferedReader
import java.io.InputStreamReader

private fun setDp(list: IntArray): IntArray {
    val n = list.size

    val dp = IntArray(n + 1)
    
    dp[0] = list[0]
    dp[1] = maxOf(list[0] + list[1], list[1])
    dp[2] = maxOf(list[0] + list[2], list[1] + list[2])
    
    for (i in 3 until n ) {
        dp[i] = maxOf(dp[i-2]+ list[i],list[i-1] + list[i] + dp[i-3])
    }
    
    return dp
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = IntArray(n)
    
    for (i in 0 until n) {
        list[i] = br.readLine().toInt()
    }
    
    if(n == 1) {
        println(list[0])
    }else if(n == 2) {
        println(maxOf(list[0] + list[1], list[1]))
    }else {
        val dp = setDp(list)

        println(dp[n-1])
    }

}