package com.sususu.wordpuzzle.infrastructure.domain

import jakarta.persistence.*

@Entity
@Table(name = "puzzle_words")
class PuzzleWord(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "puzzle_id")
    val puzzleId: Long,
    @Column(name = "word_id")
    val wordId: Long,
    @Column(name = "quiz_type")
    val quizType: String,
    @Column(name = "quiz_no")
    val quizNo: String,
) {
}
