package com.sususu.wordpuzzle.presentation.response

data class PuzzleResponse(
    val template: String,
    val quizzes: List<QuizResponse>
)
