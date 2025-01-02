package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "puzzle_word")
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

    @Column(name = "created_by")
    val createdBy: String = "system",

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_by")
    val updatedBy: String = "system",

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
}
