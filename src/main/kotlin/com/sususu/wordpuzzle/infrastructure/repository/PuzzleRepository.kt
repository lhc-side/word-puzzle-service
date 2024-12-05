package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.domain.Puzzle
import org.springframework.data.jpa.repository.JpaRepository

interface PuzzleRepository : JpaRepository<Puzzle, Long>
