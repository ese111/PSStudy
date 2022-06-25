import java.io.BufferedReader
import java.io.InputStreamReader

var arr = IntArray(10001)

private fun solution(n: Int): Int {
    if(n == 1) {
        return 1
    }
    if (n == 2) {
        return 3
    }
    arr[1] = 1
    arr[2] = 3
    for (i in 3 .. n) {
        arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 2]) % 10007
    }
    return arr[n]
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = solution(n)
    println(s)
}