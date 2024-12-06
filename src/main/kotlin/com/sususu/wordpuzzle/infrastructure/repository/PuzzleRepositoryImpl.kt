package com.sususu.wordpuzzle.infrastructure.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sususu.wordpuzzle.infrastructure.Puzzle
import com.sususu.wordpuzzle.infrastructure.QPuzzle.puzzle
import com.sususu.wordpuzzle.infrastructure.QPuzzleTemplate.puzzleTemplate
import org.springframework.stereotype.Repository

@Repository
class PuzzleRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : PuzzleRepositoryCustom {
    override fun findPuzzleById(id: Long): Puzzle {
        return queryFactory.selectFrom(puzzle)
            .join(puzzle.puzzleTemplate, puzzleTemplate).fetchJoin()
            .where(puzzle.id.eq(id))
            .fetchOne()
            ?: throw NoSuchElementException("Puzzle Not Found")
    }
}