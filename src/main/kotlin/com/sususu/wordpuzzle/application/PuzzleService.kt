package com.sususu.wordpuzzle.application

import com.sususu.wordpuzzle.infrastructure.PuzzleTemplate
import com.sususu.wordpuzzle.infrastructure.repository.PuzzleTemplateRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

@Service
class PuzzleService(
    private val puzzleTemplateRepository: PuzzleTemplateRepository
) {
    fun findPuzzleTemplateById(id: Long): PuzzleTemplate? {
       return puzzleTemplateRepository.findPuzzleTemplateById(id)
   }

    fun createPuzzles(): Array<Array<String>> {
        val template = puzzleTemplateRepository.findAnyTemplate()
        for (i in 0..< template.size) {
            for (j in 0..<template[i].size) {
                find(i, j, template)
            }
        }

         return answers
    }

    val visited = Array(5) { Array(5) { false } }
    val answers = Array(5) { Array(5) { "" } }
    val dictionary = mapOf(
        2 to listOf("가게", "가수", "상은"),
        3 to listOf("가방끈", "가로수", "국방부"),
        4 to listOf("로마제국")
    )
    val hIndex = AtomicInteger(0)
    val vIndex = AtomicInteger(0)

    private fun find(i: Int, j: Int, template: List<List<Boolean>>) {
        println("$i and $j")
        if (i < 0 || j < 0 || i >= template.size || j >= template.size) {
            return
        }
        val wordCounter1 = findHorizontal(i, j, template)
        if (wordCounter1.pq.size > 1 && !wordCounter1.alreadyFill(answers, QuizType.HORIZONTAL)) {

            val word: String
            if ("" == answers[i][j]) {
                word = dictionary[wordCounter1.pq.size]!![hIndex.getAndIncrement() % 2] // 1
            } else {
                println("${answers[i][j]} !!")
                word = dictionary[wordCounter1.pq.size]!!.first { it.contains(answers[i][j]) } // 2
            }
            while (!wordCounter1.pq.isEmpty()) {
                val w = wordCounter1.pq.poll()
                answers[i][w] = word[w - j].toString()
                visited[i][w] = true
            }
            val wordIndex = wordCounter1.getList()
            for (n in wordIndex) {
                find(i, n, template)
            }
        }

        val wordCounter2 = findVertical(i, j, template)
        if (wordCounter2.pq.size > 1 && !wordCounter2.alreadyFill(answers, QuizType.VERTICAL)) {
            val word: String
            if ("" == answers[i][j]) {
                word = dictionary[wordCounter2.pq.size]!![vIndex.get()]
            } else {
                word = dictionary[wordCounter2.pq.size]!!.first { it.contains(answers[i][j]) }
            }
            while (!wordCounter2.pq.isEmpty()) {
                val w = wordCounter2.pq.poll()
                answers[w][j] = word[w - i].toString()
                visited[w][j] = true
            }
            val wordIndex = wordCounter2.getList()
            for (n in wordIndex) {
                find(n, i, template)
            }
        }
        answers.forEach {
            println(it.contentToString())
        }
    }


    fun findVertical(i: Int, j: Int, template: List<List<Boolean>>): WordCounter {
        val visited = BooleanArray(template.size) { false }
        var count = 0
        val queue = LinkedList<Int>()
        queue.add(i)
        val pq = PriorityQueue<Int>()

        while (!queue.isEmpty()) {
            val c = queue.poll()
            if (c < 0 || c >= template.size) {
                continue
            }
            if (visited[c]) {
                continue
            }
            visited[c] = true
            if (template[c][j]) {
                pq.add(c)
                count += 1
                queue.add(c - 1)
                queue.add(c + 1)
                continue
            }
        }
        return WordCounter(pq, j)
    }

    fun findHorizontal(i: Int, j: Int, template: List<List<Boolean>>): WordCounter {
        val visited = BooleanArray(template.size) { false }
        var count = 0
        val queue = LinkedList<Int>()
        queue.add(j)
        val pq = PriorityQueue<Int>()

        while (!queue.isEmpty()) {
            val c = queue.poll()
            if (c < 0 || c >= template.size) {
                continue
            }
            if (visited[c]) {
                continue
            }
            visited[c] = true
            if (template[i][c]) {
                pq.add(c)
                count += 1
                queue.add(c - 1)
                queue.add(c + 1)
                continue
            }
        }
        return WordCounter(pq, i)
    }
}

