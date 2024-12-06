package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.PuzzleTemplate

interface PuzzleTemplateRepositoryCustom {
    fun findPuzzleTemplateById(id: Long): PuzzleTemplate?

    fun findAnyTemplate(): List<List<Boolean>> {
        return listOf(
            listOf(
                false, false, true, true, false,
            ),
            listOf(
                true, true, true, false, true,
            ),
            listOf(
                false, true, false, false, true,
            ),
            listOf(
                false, true, false, false, false,
            ),
            listOf(
                false, true, true, true, false,
            ),
        )
    }
}
