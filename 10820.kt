import java.io.BufferedReader
import java.io.InputStreamReader

private fun setArray(str: String): IntArray {
    val n = str.length
    val array = IntArray(4){0}

    for (i in 0 until n) {
        when(str[i].code) {
            in 97..122 -> array[0]++
            in 65..90 -> array[1]++
            in 48..57 -> array[2]++
            32 -> array[3]++
        }
    }

    return array
}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    var str: String?
    while (br.readLine().also { str = it } != null) {

        val arr = str?.let { setArray(it) }

        arr?.forEach {
            bw.write("".plus(it))
            bw.write(" ")
        }
        bw.write("\n")
    }
    
    bw.flush()
    bw.close()
    br.close()
}