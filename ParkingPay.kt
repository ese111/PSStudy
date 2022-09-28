
import kotlin.collections.HashMap
import kotlin.math.ceil

data class Car(
    val time: Int,
    val num: String,
    val state: String
)
private const val ALL_DAY = 23 * 60 + 59

class Solution {
    
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val enter: HashMap<String,Car> = HashMap()
        val list = records.map {
            val car = it.split(" ")
            val time = car[0].split(":")
            val hour = time[0].toInt() * 60
            val min = time[1].toInt()
            Car(hour + min, car[1], car[2])
        }
        val byToCarNumber = compareBy<Car> { it.num }
        val arr = list.sortedWith(byToCarNumber)

        val out = mutableMapOf<String, Int>()
        arr.forEach {
            out[it.num] = 0
        }

        arr.forEach {
            println(enter)
            println(it)
            if(it.state == "IN") {
                enter[it.num] = it
            } else {
                val car = enter[it.num]!!
                enter.remove(it.num)
                out[it.num] = out[it.num]?.plus(it.time - car.time) ?: 0
            }
        }
        if(enter.isNotEmpty()) {
            enter.forEach { (key, value) ->
                out[key] = out[key]?.plus(ALL_DAY - value.time) ?: 0
            }
        }

        val answer = out.map {
            val value = if(ceil((it.value - fees[0]) / fees[2].toDouble()) < 0) {
                0
            } else {
                ceil((it.value - fees[0]) / fees[2].toDouble())
            }
            fees[1] + value.toInt() * fees[3]
        }

        return answer.toIntArray()
    }
}
