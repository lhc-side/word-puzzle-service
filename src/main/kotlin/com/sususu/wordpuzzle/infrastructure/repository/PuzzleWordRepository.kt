package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.domain.PuzzleWord
import org.springframework.data.jpa.repository.JpaRepository

interface PuzzleWordRepository : JpaRepository<PuzzleWord, Long>
