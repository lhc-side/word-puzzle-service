package com.sususu.wordpuzzle.infrastructure.domain

import jakarta.persistence.*

@Entity
@Table(name = "puzzle_submissions")
class PuzzleSubmission(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "puzzle_id")
    val puzzleId: Long,

    @Column(name = "contents")
    val contents: String,
){
}
