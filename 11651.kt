import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private fun setDp(list: List<Pair<Int, Int>>): StringBuilder {
    val arr = list.sortedWith { d1, d2 ->
        if (d1.second == d2.second) {
            d1.first - d2.first
        } else {
            d1.second - d2.second
        }
    }
    val sb = StringBuilder()
    for (i in 0 until arr.size) {
        sb.append(arr[i].first)
        sb.append(" ")
        sb.append(arr[i].second)
        sb.append("\n")
    }
    return sb
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = ArrayList<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (x,y) = br.readLine().split(" ").map { it.toInt() }
        list.add(Pair(x,y))
    }

    val ans = setDp(list)

    println(ans)
}


