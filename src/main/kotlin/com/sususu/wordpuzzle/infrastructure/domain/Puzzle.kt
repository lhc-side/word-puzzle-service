package com.sususu.wordpuzzle.infrastructure.domain

import jakarta.persistence.*

@Entity
@Table(name = "puzzles")
class Puzzle(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "template_id")
    val templateId: Long,
) {
}
