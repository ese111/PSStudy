import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private fun setDp(list: List<Int>): StringBuilder {
    val sb = StringBuilder()
    Collections.sort(list)

    for (i in list.iterator()) {
        sb.append(i).append('\n')
    }

    return sb
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = ArrayList<Int>()
    for (i in 0 until n) {
        list.add(br.readLine().toInt())
    }

    val ans = setDp(list)

    println(ans)
}


