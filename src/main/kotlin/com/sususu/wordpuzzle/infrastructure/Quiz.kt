package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "quiz")
data class Quiz(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "puzzle_id")
    val puzzle: Puzzle,

    @ManyToOne
    @JoinColumn(name = "word_id")
    val word: Word,

    @Column
    val quizType: String,

    @Column
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
    val wordDescription: String
        get() = word.description
}
