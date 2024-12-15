package com.sususu.wordpuzzle.client.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
@EnableConfigurationProperties(DictionaryApiRestClientProperties::class)
class DictionaryApiRestClientConfig {

    @Bean
    fun dictionaryApiRestClient(properties: DictionaryApiRestClientProperties): RestClient {
        return RestClient.builder()
            .baseUrl(properties.baseUrl)
            .build()
    }
}