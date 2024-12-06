package com.sususu.wordpuzzle.application

import java.util.*

class WordCounter(
    val pq: PriorityQueue<Int> = PriorityQueue(),
    val fixed: Int
) {
    fun alreadyFill(answers: Array<Array<String>>, quizType: QuizType): Boolean {
        val tempPQ = PriorityQueue(pq)
        var count = 0
        while (!tempPQ.isEmpty()) {
            val num = tempPQ.poll()
            if (quizType.getCoord(answers, num, fixed) != "") {
                count += 1
            }
        }
        return count >= pq.size
    }

    fun getList(): List<Int> {
        return pq.toList()
    }
}
