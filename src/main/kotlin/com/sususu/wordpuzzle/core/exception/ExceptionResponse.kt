package com.sususu.wordpuzzle.core.exception

import java.time.LocalDateTime

data class ExceptionResponse(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)