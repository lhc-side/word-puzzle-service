package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*

@Entity
@Table(name = "word")
data class Word(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val word: String,

    @Column
    val description: String,

    @OneToMany
    val quizzes: List<Quiz>
)
