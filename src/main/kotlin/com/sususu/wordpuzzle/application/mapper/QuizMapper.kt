package com.sususu.wordpuzzle.application.mapper

import com.sususu.wordpuzzle.infrastructure.Quiz
import com.sususu.wordpuzzle.presentation.response.QuizResponse

object QuizMapper {
    fun toResponse(quiz: Quiz): QuizResponse {
        return QuizResponse(
            quizType = quiz.quizType,
            quizNo = quiz.quizNo,
            quiz = quiz.wordDescription
        )
    }
}