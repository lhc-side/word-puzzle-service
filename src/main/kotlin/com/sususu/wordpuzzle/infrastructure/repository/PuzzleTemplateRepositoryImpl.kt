package com.sususu.wordpuzzle.infrastructure.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sususu.wordpuzzle.infrastructure.PuzzleTemplate
import com.sususu.wordpuzzle.infrastructure.QPuzzleTemplate.puzzleTemplate
import org.springframework.stereotype.Repository

@Repository
class PuzzleTemplateRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : PuzzleTemplateRepositoryCustom {

    override fun findPuzzleTemplateById(id: Long): PuzzleTemplate? {
        return queryFactory.selectFrom(puzzleTemplate)
            .where(puzzleTemplate.id.eq(id))
            .fetchFirst()
    }
}
