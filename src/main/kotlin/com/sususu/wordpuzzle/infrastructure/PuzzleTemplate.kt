package com.sususu.wordpuzzle.infrastructure

import com.sususu.wordpuzzle.presentation.response.PuzzleTemplateResponse
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

    @OneToMany
    val puzzles: List<Puzzle>

) {
    fun toResponse(): PuzzleTemplateResponse {
        return PuzzleTemplateResponse(
            id = this.id,
            contents = this.contents
        )
    }
}

