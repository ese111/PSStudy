import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private fun editor(n: Int, str: String, br: BufferedReader): LinkedList<Char> {
    val list = LinkedList<Char>()
    str.forEach { list.add(it) }
    val iterator = list.listIterator()
    while (iterator.hasNext()) {
        iterator.next()
    }
    for (i in 0 until n) {
        val input = br.readLine().split(" ")
        when(input[0]) {
            "L" -> {
                if(iterator.hasPrevious()) iterator.previous()
            }
            "D" -> {
                if (iterator.hasNext()) iterator.next()
            }
            "B" -> {
                if(iterator.hasPrevious()) {
                    iterator.previous()
                    iterator.remove()
                }
            }
            "P" -> {
                iterator.add(input[1][0])
            }
        }
    }
    return list
}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    val str = br.readLine()
    val n = br.readLine().toInt()
    val ans = editor(n,str, br)

    bw.write(ans.toCharArray())

    bw.flush()
    bw.close()
    br.close()
}