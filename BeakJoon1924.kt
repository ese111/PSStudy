import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private fun calenda(x: StringTokenizer): String {
    val month = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val day = arrayListOf<String>("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
    var todayMonth = x.nextToken().toInt()
    var today = x.nextToken().toInt()
    var k = 0
    var d = ""
    for (i in 0 until  todayMonth) {
        for (j in 0 until month[i]) {
            if(k > 6){
                k = 0
            }
            d = day[k]
            k++
            if(i == todayMonth-1 && j == today-1) {
                return d
            }
        }
    }
    return d
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine()
    val today = StringTokenizer(x, " ")
    println(calanda(today))
}