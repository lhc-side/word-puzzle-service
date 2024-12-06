package com.sususu.wordpuzzle.infrastructure.support

import com.sususu.wordpuzzle.infrastructure.PuzzleTemplate
import com.sususu.wordpuzzle.infrastructure.repository.PuzzleTemplateRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class PostInitializer(
    private val puzzleTemplateRepository: PuzzleTemplateRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        puzzleTemplateRepository.save(
            PuzzleTemplate(
                contents = "1234"
            )
        )
    }
}
