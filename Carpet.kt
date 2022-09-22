class Solution {
     fun solution(brown: Int, yellow: Int): IntArray {
        val answer = intArrayOf(0, 0)
        val size = brown + yellow
        var i = 3
        while (true) {
            if (size % i != 0 || size / i < 3) {
                i++
                continue
            }
            val tmp = size / i
            val y = (i - 2) * (tmp - 2)
            val b = size - y
            if(y == yellow && b == brown) {
                answer[0] = tmp.coerceAtLeast(i)
                answer[1] = tmp.coerceAtMost(i)
                break
            }
            i++
        }
        return answer
    }
}