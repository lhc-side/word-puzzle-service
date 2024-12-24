package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.domain.PuzzleSubmission
import org.springframework.data.jpa.repository.JpaRepository

interface PuzzleSubmissionRepository : JpaRepository<PuzzleSubmission, Long>
