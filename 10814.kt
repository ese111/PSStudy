import java.io.BufferedReader
import java.io.InputStreamReader

private fun setDp(list: List<Pair<Int, String>>): StringBuilder {
    val arr = list.sortedWith { d1, d2 ->
        if (d1.first != d2.first) {
            d1.first - d2.first
        } else {
            list.indexOf(d1) - list.indexOf(d2)
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
    val list = ArrayList<Pair<Int, String>>()

    for (i in 0 until n) {
        val (x,y) = br.readLine().split(" ")
        list.add(Pair(x.toInt(),y))
    }

    val ans = setDp(list)

    println(ans)
}


