class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val list = mutableListOf<Int>()
        for (i in left..right) {
            list.add(maxOf((i/n).toInt(), (i%n).toInt()) + 1)
        }
        return list.toIntArray()
    }
}