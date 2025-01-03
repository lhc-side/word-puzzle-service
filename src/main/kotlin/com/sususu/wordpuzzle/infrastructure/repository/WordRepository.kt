package com.sususu.wordpuzzle.infrastructure.repository

import com.sususu.wordpuzzle.infrastructure.Word
import org.springframework.data.jpa.repository.JpaRepository

interface WordRepository : JpaRepository<Word, Long>
