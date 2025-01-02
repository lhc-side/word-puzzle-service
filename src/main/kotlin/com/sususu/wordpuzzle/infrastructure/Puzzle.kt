package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "puzzle")
data class Puzzle(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "template_id")
    val puzzleTemplate: PuzzleTemplate,

    @OneToMany(mappedBy = "puzzle")
    val quizzes: List<Quiz>,

    @Column(name = "created_by")
    val createdBy: String = "system",

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_by")
    val updatedBy: String = "system",

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    val puzzleTemplateContents: String
        get() = puzzleTemplate.contents
}
