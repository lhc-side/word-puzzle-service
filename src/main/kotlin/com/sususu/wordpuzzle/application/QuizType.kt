package com.sususu.wordpuzzle.application

enum class QuizType {
    VERTICAL,
    HORIZONTAL,
    ;

    fun getCoord(answers: Array<Array<String>>, num: Int, fixed: Int): String {
        return if (this == HORIZONTAL) answers[fixed][num] else answers[num][fixed]
    }
}
