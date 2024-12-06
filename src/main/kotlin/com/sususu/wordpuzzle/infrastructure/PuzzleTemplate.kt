package com.sususu.wordpuzzle.infrastructure

import com.sususu.wordpuzzle.presentation.response.PuzzleTemplateResponse
import jakarta.persistence.*

@Entity
@Table(name = "puzzle_templates")
data class PuzzleTemplate(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "contents")
    val contents: String

) {
    fun toResponse(): PuzzleTemplateResponse {
        return PuzzleTemplateResponse(
            id = this.id,
            contents = this.contents
        )
    }
}
