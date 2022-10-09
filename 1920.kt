import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections.sort

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val M = br.readLine().toInt()
    val find = br.readLine().split(" ").map { it.toInt() }


    sort(arr)

    find.forEach {
        var max = arr.size
        var min = 0

        var answer = 0
        while (max > min) {
            val mid = (max + min) / 2
            if(it < arr[mid]) {
                max = mid
            } else if(it > arr[mid]) {
                min = mid + 1
            } else {
                answer++
                break
            }
        }
        println(answer)
    }

}