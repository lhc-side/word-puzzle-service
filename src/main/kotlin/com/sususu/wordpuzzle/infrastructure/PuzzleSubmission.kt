package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "puzzle_submission")
class PuzzleSubmission(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "puzzle_id")
    val puzzleId: Long,

    @Column(name = "contents")
    val contents: String,

    @Column(name = "created_by")
    val createdBy: String = "system",

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_by")
    val updatedBy: String = "system",

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)
