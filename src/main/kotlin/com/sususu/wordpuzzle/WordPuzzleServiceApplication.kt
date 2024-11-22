package com.sususu.wordpuzzle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WordPuzzleServiceApplication

fun main(args: Array<String>) {
    runApplication<WordPuzzleServiceApplication>(*args)
}
