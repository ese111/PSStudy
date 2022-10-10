package com.example.codingtest

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun find(cards: Queue<Int>): Int {
    var i = 0
    while (cards.isNotEmpty()) {
        if(i % 2 == 0) {
            cards.poll()
        } else {
            val card = cards.poll()
            cards.offer(card)
        }

        if (cards.size == 1) {
            return cards.poll()
        }

        i++
    }
    return -1
}

private fun getCards(n: Int): Queue<Int> {
    val cards: Queue<Int> = LinkedList()

    for (i in 1 .. n) {
        cards.offer(i)
    }
    return cards
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    if(n == 1) {
        println(1)
        return
    }
    val cards = getCards(n)
    println(find(cards))

}