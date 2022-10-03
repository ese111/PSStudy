// 1. 처음 풀이
class Solution {
    fun solution(s: String): String {
        val answer = StringBuilder()
        val arr = s.split(" ")
    
        arr.forEachIndexed { i, str ->
           str.mapIndexed { j, c ->
               if(j == 0 || s[j - 1] != " ") {
                   answer.append(c.uppercaseChar())
               } else {
                   answer.append(c.lowercase())
               }
           }
           if (i != arr.size - 1) {
               answer.append(" ")
           }
        }
        return answer.toString()
    }
}

// 2. 다음 풀이

class Solution {
    fun solution(s: String): String {
        val answer = StringBuilder()
        s.mapIndexed { j, c ->
            if(j == 0 || s[j - 1] == ' ') {
                answer.append(c.uppercaseChar())
            } else {
                answer.append(c.lowercase())
            }
        }
        return answer.toString()
    }
}