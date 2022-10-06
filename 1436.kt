import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var num = 666
    var count = 1
    while (count != n) {
        num++
        if(num.toString().contains("666")) {
            count++
        }
    }
    println(num)
}