package com.sususu.wordpuzzle.application

import com.sususu.wordpuzzle.infrastructure.PuzzleTemplate
import com.sususu.wordpuzzle.infrastructure.repository.PuzzleTemplateRepository
import org.springframework.stereotype.Service

@Service
class PuzzleService(
    private val puzzleTemplateRepository: PuzzleTemplateRepository
) {
    fun findPuzzleTemplateById(id: Long): PuzzleTemplate? {
       return puzzleTemplateRepository.findPuzzleTemplateById(id)
   }
}