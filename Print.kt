package com.example.codingtest

import java.util.*

data class Item(
    val id: Int,
    val important: Int
)

class S {

    private fun max(queue: Queue<Item>, print: Item): Boolean {
        queue.forEach {
            if(print.important < it.important) {
                    queue.offer(print)
                    return false
                }
        }
        return true
    }

    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val queue: Queue<Item> = LinkedList()

        for (i in priorities.indices) {
            queue.offer(Item(i, priorities[i]))
        }

        while (queue.isNotEmpty()) {
            val print = queue.poll()
            if(max(queue, print)) {
                if (print.id == location) {
                    return answer + 1
                } else {
                    answer ++
                }
            }
        }

        return answer + 1
    }
}
