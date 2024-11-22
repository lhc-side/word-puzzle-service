package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.PuzzleTemplate

interface PuzzleTemplateRepositoryCustom {
    fun findPuzzleTemplateById(id: Long): PuzzleTemplate?
}