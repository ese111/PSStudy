import java.io.BufferedReader
import java.io.InputStreamReader

private fun getNumbers() : IntArray {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = mutableListOf<Int>()
    while (true) {
        val num = br.readLine().toInt()
        if(num == 0) {
            break
        }
        arr.add(num)
    }
    return arr.toIntArray()
}

private fun isPalindrome(palindrome: String): Boolean {
    val leng = palindrome.length
    if(leng == 1) {
        return true
    }
    var search = leng - 1
    var check = true
    for (i in 0 until leng / 2) {
        if(palindrome[i] != palindrome[search]) {
            check = false
        }
        search--
    }
    return check
}

fun main() {
    val arr = getNumbers()

    val answer = arr.map {
        val palindrome = it.toString()
        if(!isPalindrome(palindrome)) {
            "no"
        } else {
            "yes"
        }
    }
    answer.forEach {
        println(it)
    }
}