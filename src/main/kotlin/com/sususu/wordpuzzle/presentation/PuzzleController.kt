package com.sususu.wordpuzzle.presentation

import com.sususu.wordpuzzle.application.PuzzleService
import com.sususu.wordpuzzle.presentation.response.PuzzleResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PuzzleController(private val puzzleService: PuzzleService) {
    @GetMapping("/puzzle")
    fun findPuzzle(@RequestParam(required = false) id: Long): ResponseEntity<PuzzleResponse> =
        ResponseEntity.ok(puzzleService.findPuzzle(id))
}