package com.sususu.wordpuzzle.application

import com.sususu.wordpuzzle.application.mapper.PuzzleMapper
import com.sususu.wordpuzzle.infrastructure.repository.PuzzleRepository
import com.sususu.wordpuzzle.presentation.response.PuzzleResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PuzzleService(
    private val puzzleRepository: PuzzleRepository
) {
    @Transactional(readOnly = true)
    fun findPuzzle(id: Long?): PuzzleResponse {
        // todo: random key with null situation
        val puzzleId = id ?: 1L

        return PuzzleMapper.toResponse(puzzleRepository.findPuzzleById(puzzleId))
    }
}