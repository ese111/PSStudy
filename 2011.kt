import java.io.BufferedReader
import java.io.InputStreamReader

private fun setDp(array: String): Long {
    val n = array.length
    val dp = LongArray(n + 1)
    dp[0] = 1
    val list = getList(array)

    for (i in 1..n) {
        if(list[i] in 1..9) {
            dp[i] = dp[i - 1] % 1000000
        }
        if (i==1) {
            continue
        }
        val x = list[i] + list[i - 1] * 10
        if(x in 10..26) {
            dp[i] = (dp[i] + dp[i - 2]) % 1000000
        }
    }
    return dp[n] % 1000000
}

private fun getList(str: String): IntArray {
    val n = str.length
    val list = IntArray(n + 1)
    for (i in 1.. n) {
        list[i] = Character.getNumericValue(str[i - 1])
    }
    return list
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val array = br.readLine()
    println(setDp(array))
}


