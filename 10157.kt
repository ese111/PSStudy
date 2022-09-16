import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val UP = "up"
const val DOWN = "down"
const val RIGHT = "right"
const val LEFT = "left"

fun checkSeat(seat: List<Int>, num: Int ): String {
    val map = Array(seat[1]){ BooleanArray(seat[0]) }

    var answer = "0"

    var y = 0
    var x = 0
    var cnt = 1
    var flag = UP

    map[y][x] = true

    while (cnt != num) {
        
        if(num > seat[0] * seat[1]) {
            return answer
        }
        
        when(flag) {
            UP -> {
                val tmpY = y + 1
                if(tmpY in 0 until seat[1]) {
                    if(!map[tmpY][x]) {
                        y = tmpY
                        cnt++
                    } else {
                        flag = RIGHT
                    }
                } else {
                    flag = RIGHT
                }
            }
            DOWN -> {
                val tmpY = y - 1
                if(tmpY in 0 until seat[1]) {
                    if(!map[tmpY][x]) {
                        y = tmpY
                        cnt++
                    } else {
                        flag = LEFT
                    }
                } else {
                    flag = LEFT
                }
            }
            RIGHT -> {
                val tmpX = x + 1
                if(tmpX in 0 until seat[0]) {
                    if(!map[y][tmpX]) {
                        x = tmpX
                        cnt++
                    } else {
                        flag = DOWN
                    }
                } else {
                    flag = DOWN
                }
            }
            LEFT -> {
                val tmpX = x - 1
                if(tmpX in 0 until seat[0]) {
                    if(!map[y][tmpX]) {
                        x = tmpX
                        cnt++
                    } else {
                        flag = UP
                    }
                } else {
                    flag = UP
                }
            }
        }
        map[y][x] = true
    }

    if(x != seat[0] && y != seat[1]) {
        answer =  "${x + 1} ${y + 1}"
    }
    return answer
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val seat = br.readLine().split(" ").map { it.toInt() }
    val num = br.readLine().toInt()

    println(checkSeat(seat, num))

}