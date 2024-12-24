package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*

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
    @JoinColumn(name =  "word_id")
    val word: Word,

    @Column
    val quizType: String,

    @Column
    val quizNo: String,
) {
    val wordDescription: String
        get() = word.description
}
