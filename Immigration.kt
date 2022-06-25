fun solution(n: Int, times: IntArray): Long {
    var min = n / times.size * times.minOrNull()!!
    var max = n * times.maxOrNull()!!
    while (min <= max) {
        var mid = (max + min) / 2
        var count = 0
        times.forEach {
            count += mid / it
        }

        if (count >= n) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }
    return max.toLong() + 1
}