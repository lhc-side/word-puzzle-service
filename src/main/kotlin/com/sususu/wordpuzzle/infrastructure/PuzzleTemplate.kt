package com.sususu.wordpuzzle.infrastructure

import com.sususu.wordpuzzle.presentation.response.PuzzleTemplateResponse
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "puzzle_templates")
data class PuzzleTemplate(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "contents")
    val contents: String,

    @Column(name = "created_by")
    val createdBy: String = "SYSTEM",

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),


    @Column(name = "updated_by")
    val updatedBy: String = "SYSTEM",

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now()

) {
    fun toResponse(): PuzzleTemplateResponse {
        return PuzzleTemplateResponse(
            id = this.id,
            contents = this.contents
        )
    }
}
