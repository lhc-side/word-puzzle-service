package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.PuzzleTemplate
import org.springframework.data.jpa.repository.JpaRepository

interface PuzzleTemplateRepository : JpaRepository<PuzzleTemplate, Long>, PuzzleTemplateRepositoryCustom {

}