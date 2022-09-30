class Solution {

    fun solution(s: String): IntArray {

        val tmpTuple = s
            .replace("{", "")
            .replace("},", " ")
            .replace("}}", "")
            .split(" ")
            .sortedBy { it.length }
        val list = mutableListOf<Int>()
        tmpTuple.forEach {
            println(it)
            it.split(",").forEach {
                list.add(it.toInt())
            }
        }
        val tuple = list.distinct()
        val answer = IntArray(tuple.size)
        tuple.forEachIndexed { index, i ->
            answer[index] = i
        }
        return answer
    }
}