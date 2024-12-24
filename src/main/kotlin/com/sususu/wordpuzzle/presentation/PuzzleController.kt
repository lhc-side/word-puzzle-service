package com.sususu.wordpuzzle.presentation

import com.sususu.wordpuzzle.application.PuzzleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PuzzleController(private val puzzleService: PuzzleService) {
    @PostMapping("/puzzles")
    fun createPuzzles(): PuzzleResponse {
        return PuzzleResponse(puzzleService.createPuzzles())
    }

    // fixme: class사용 논의 필요
    @GetMapping("/puzzles/{id}")
    fun findPuzzle(@PathVariable id: Long): ResponseEntity<com.sususu.wordpuzzle.presentation.response.PuzzleResponse> =
        ResponseEntity.ok(puzzleService.findPuzzle(id))
}

data class PuzzleResponse(
    val puzzle: Array<Array<String>>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PuzzleResponse

        return puzzle.contentDeepEquals(other.puzzle)
    }

    override fun hashCode(): Int {
        return puzzle.contentDeepHashCode()
    }
}
