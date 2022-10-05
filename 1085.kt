import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y, w, h) = br.readLine().split(" ").map { it.toInt() }

    val colum = min(h-y, y)
    val row = min(w-x, x)
    println(min(colum, row))
}