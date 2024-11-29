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

    @OneToMany
    val quizzes: List<Quiz>,

)
