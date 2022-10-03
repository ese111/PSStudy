class Solution {
    fun solution(s: String): String {
        val answer = StringBuilder()

        val list = s.split(" ").map { it.toInt() }
        var max = list[0]
        var min = list[0]
        for (i in 1 until list.size) {
            max = maxOf(max, list[i])
            min = minOf(min, list[i])
        }
        return answer.append(min).append(" ").append(max).toString()
    }
}