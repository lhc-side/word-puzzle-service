package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.Puzzle

interface PuzzleRepositoryCustom {
    fun findPuzzleById(id: Long): Puzzle
}