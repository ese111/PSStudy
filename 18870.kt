import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private fun getIndexMap(arr: IntArray): Map<Int, Int> {
    val map = mutableMapOf<Int, Int>()

    val list = arr.distinct().sorted()
    list.forEachIndexed { index, i ->
        map[i] = index
    }
    return map
}

private fun getAnswer(arr: IntArray, map: Map<Int, Int>): String {
    val sb = StringBuilder()
    arr.forEachIndexed { i, int ->
        if(i != 0) {
            sb.append(" ")
        }
        sb.append(map[int])
    }
    return sb.toString()
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val map = getIndexMap(arr)

    bw.write(getAnswer(arr, map))
    bw.flush()
    bw.close()
}