package com.sususu.wordpuzzle.presentation

import com.sususu.wordpuzzle.application.PuzzleService
import com.sususu.wordpuzzle.presentation.response.PuzzleResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PuzzleController(private val puzzleService: PuzzleService) {
    @PostMapping("/puzzles")
    fun createPuzzles(): PuzzleResponse {
        return PuzzleResponse(puzzleService.createPuzzles())
    }

    @GetMapping("/puzzle")
    fun findPuzzle(@RequestParam(required = false) id: Long): ResponseEntity<PuzzleResponse> =
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
