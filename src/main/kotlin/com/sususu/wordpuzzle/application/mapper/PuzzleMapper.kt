package com.sususu.wordpuzzle.application.mapper

import com.sususu.wordpuzzle.infrastructure.Puzzle
import com.sususu.wordpuzzle.presentation.response.PuzzleResponse

object PuzzleMapper {
    fun toResponse(puzzle: Puzzle): PuzzleResponse {
        return PuzzleResponse(
            puzzleId = puzzle.id,
            template = puzzle.puzzleTemplateContents,
            quizzes = puzzle.quizzes.map(QuizMapper::toResponse)
        )
    }
}