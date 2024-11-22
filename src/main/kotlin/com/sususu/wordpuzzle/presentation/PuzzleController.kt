package com.sususu.wordpuzzle.presentation

import com.sususu.wordpuzzle.application.PuzzleService
import com.sususu.wordpuzzle.presentation.response.PuzzleTemplateResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PuzzleController(private val puzzleService: PuzzleService) {
    @GetMapping("/puzzle-template/{id}")
    fun findPuzzleTemplate(@PathVariable id: Long): ResponseEntity<PuzzleTemplateResponse> =
        ResponseEntity.ok(puzzleService.findPuzzleTemplateById(id)?.toResponse())
}