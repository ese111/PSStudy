const val MAX = 1000001

private fun getPrime(): BooleanArray {
    val arr = BooleanArray(MAX)
    arr[1] = true
    for (i in 2..1000000) {
        if (!arr[i]) {
            for (j in i * 2..1000000 step (i)) {
                arr[j] = true
            }
        }
    }
    return arr
}

private fun getAnswer(n: Int, arr: BooleanArray): StringBuilder {
    val sb = StringBuilder()
    for (i in 3..n) {
        if (!arr[i] && !arr[n - i]) {
            sb.appendLine("$n = $i + ${n - i}")
            return sb
        }
    }

    sb.appendLine("Goldbach's conjecture is wrong.")
    return sb
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val arr = getPrime()

    while (true) {
        val n = br.readLine().toInt()
        if(n == 0) {
            break
        }
        bw.write(getAnswer(n, arr).toString())
    }


    bw.flush()
    bw.close()
    br.close()
}