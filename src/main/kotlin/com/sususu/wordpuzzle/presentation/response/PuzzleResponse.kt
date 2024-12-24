package com.sususu.wordpuzzle.presentation.response

import com.sususu.wordpuzzle.infrastructure.Puzzle

data class PuzzleResponse(
    val puzzleId: Long,
    val template: String,
    val quizzes: List<QuizResponse>
)
