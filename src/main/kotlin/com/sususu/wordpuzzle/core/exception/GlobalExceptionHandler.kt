package com.sususu.wordpuzzle.core.exception

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@Order(-1)
@RestControllerAdvice
class GlobalExceptionHandler {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(Exception::class)
    fun handlerException(request: HttpServletRequest, e: Exception): ResponseEntity<ExceptionResponse> {
        return createResponseEntity(request, e, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handlerException(request: HttpServletRequest, e: NoSuchElementException): ResponseEntity<ExceptionResponse> {
        return createResponseEntity(request, e, HttpStatus.BAD_REQUEST)
    }

    private fun createResponseEntity(
        request: HttpServletRequest,
        e: Throwable,
        httpStatus: HttpStatus
    ): ResponseEntity<ExceptionResponse> {
        sendErrorLog(request, e)

        return ResponseEntity.status(httpStatus).body(
            ExceptionResponse(
                timestamp = LocalDateTime.now(),
                status = httpStatus.value(),
                error = httpStatus.reasonPhrase,
                message = e.message ?: "",
                path = request.requestURI
            )
        )
    }

    private fun sendErrorLog(request: HttpServletRequest, e: Throwable) {
        log.error("ERROR!! ${request.requestURI}", e)
    }
}