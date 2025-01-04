package com.sususu.wordpuzzle.core.config

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration

@ConfigurationProperties(prefix = "dictionary-api")
data class DictionaryApiRestClientProperties(
    val connectionTimeout: Duration,
    val readTimeout: Duration,
    val baseUrl: String,
    val apiKey: String
)
