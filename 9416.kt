import java.io.BufferedReader
import java.io.InputStreamReader

private fun setDp(n: Int) {
    val dp = LongArray(n + 1)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 1

    for (i in 3 until n) {
        dp[i] = dp[i - 3] + dp[i - 2]
    }

    println(dp[n - 1])
}

private fun sizeChecker(n : Int) = when(n < 4) {
    true -> println(1)
    false -> setDp(n)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val case = IntArray(n)

    for (i in 0 until n) {
        case[i] = br.readLine().toInt()
    }

    case.forEach {
        sizeChecker(it)
    }
}


