import java.io.BufferedReader
import java.io.InputStreamReader

private fun setArray(str: String): IntArray {
    val n = str.length
    val array = IntArray(26){0}
    str.forEach {
        array[it - 'a']++
    }
    return array
}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()

    val bw = System.out.bufferedWriter()

    val arr = setArray(str)
    arr.forEach {
        bw.write("".plus(it))
        bw.write(" ")
    }

    bw.flush()
    bw.close()
    br.close()
}