package com.example.codingtest

import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray) {
        var answer = 0
        var basket = Stack<Int>()
        for (i in 0 until moves.size!!) {
            for (j in 0 until board.size!!) {
                if (board[j][moves[j] - 1] != 0) {
                    if (!basket.isEmpty() && basket.peek() == board[j][moves[i] - 1]) {
                        basket.pop()
                        board[j][moves[i] - 1] = 0
                        answer++
                    } else {
                        basket.push(board[j][moves[i] - 1])
                        board[j][moves[i] - 1] = 0
                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val a: Array<IntArray> = arrayOf(
        intArrayOf(0,0,0,0,0),
        intArrayOf(0,0,1,0,3),
        intArrayOf(0,2,5,0,1),
        intArrayOf(4,2,4,4,2),
        intArrayOf(3,5,1,3,1))
    val move: IntArray = intArrayOf(1,5,3,5,1,2,1,4)
    println(Solution().solution(a, move))
}