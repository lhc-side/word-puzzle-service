package com.sususu.wordpuzzle.client.config

import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter
import org.springframework.web.client.RestClient

@Configuration
@EnableConfigurationProperties(DictionaryApiRestClientProperties::class)
class DictionaryApiRestClientConfig {

    @Bean
    fun dictionaryApiRestClient(properties: DictionaryApiRestClientProperties, messageConverters: HttpMessageConverters): RestClient {
        val queryParam = "key=${properties.apiKey}&start=1&num=100&sort=dict&advanced=y&pos=1&pos=2"

        return RestClient.builder()
            .baseUrl("${properties.baseUrl}?${queryParam}")
            .build()
    }
}