package com.sususu.wordpuzzle.infrastructure

import jakarta.persistence.*

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
) {
    val puzzleTemplateContents: String
        get() = puzzleTemplate.contents
}
