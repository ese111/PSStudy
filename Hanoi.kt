
class Solution {
    val list = mutableListOf<IntArray>()

    private fun hanoi(n: Int, from: Int, to: Int, via: Int) {
        if(n == 1) {
            list.add(intArrayOf(from, to))
        } else {
            hanoi(n - 1, from, via, to)
            list.add(intArrayOf(from, to))
            hanoi(n - 1, via, to, from)
        }
    }
    fun solution(n: Int): Array<IntArray> {
        hanoi(n, 1, 3, 2)
        return list.toTypedArray()
    }
}