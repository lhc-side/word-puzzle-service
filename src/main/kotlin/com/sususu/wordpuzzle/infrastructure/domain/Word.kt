package com.sususu.wordpuzzle.infrastructure.domain

import jakarta.persistence.*

@Entity
@Table(name = "words")
class Word(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "word")
    val word: String,

    @Column(name = "description")
    val description: String,
) {
}
