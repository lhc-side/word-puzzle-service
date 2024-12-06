package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*

@Entity
@Table(name = "puzzle_template")
data class PuzzleTemplate(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "contents")
    val contents: String,

    @OneToMany(mappedBy = "puzzleTemplate")
    val puzzles: List<Puzzle>

)

