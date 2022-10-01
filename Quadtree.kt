class Solution {
    private val answer = IntArray(2)

    private fun dfs(arr: Array<IntArray>, row: Int, column: Int, n: Int) {
        var pass = true

        if (n == 1) {
            answer[arr[column][row]]++
        } else {

            One@for (i in column until n + column) {
                for (j in row until n + row) {
                    println("arr[$i][$j] = ${arr[i][j]} n = $n")
                    if (arr[column][row] != arr[i][j]) {
                        pass = false
                        break@One
                    }
                }
            }

            if (pass) {
                answer[arr[column][row]]++
                return
            }
            dfs(arr, row, column, n / 2)
            dfs(arr, row, column + n / 2, n / 2)
            dfs(arr, row + n / 2, column, n / 2)
            dfs(arr, row + n / 2, column + n / 2, n / 2)
        }
    }

    fun solution(arr: Array<IntArray>): IntArray {
        dfs(arr, 0, 0, arr.size)
        return answer
    }

}