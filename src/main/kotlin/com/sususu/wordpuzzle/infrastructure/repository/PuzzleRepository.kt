package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.Puzzle
import org.springframework.data.jpa.repository.JpaRepository

interface PuzzleRepository : JpaRepository<Puzzle, Long>, PuzzleRepositoryCustom