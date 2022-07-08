import java.io.BufferedReader
import java.io.InputStreamReader

private fun rot13(str: String): String {
    val n = str.length
    var password = ""
    for (i in 0 until n) {
        when(str[i].code) {
            in 97..122 -> password += small(str[i].code)
            in 65..90 -> password += big(str[i].code)
            in 48..57 -> password += str[i]
            32 -> password += " "
        }
    }

    return password
}

private fun small(data: Int): Char {
    var char = 0
    if(data + 13 > 122) {
        char = (data + 13 - 123 + 97)
    } else {
        char = data + 13
    }
    return char.toChar()
}

private fun big(data: Int): Char {
    var char = 0
    if(data + 13 > 90) {
        char = (data + 13 - 91 + 65)
    } else {
        char = data + 13
    }
    return char.toChar()
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    var str = br.readLine()

    bw.write("".plus(rot13(str)))

    bw.flush()
    bw.close()
    br.close()
}