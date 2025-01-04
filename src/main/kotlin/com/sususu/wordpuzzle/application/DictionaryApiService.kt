package com.sususu.wordpuzzle.application

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.sususu.wordpuzzle.client.dto.SearchDictionaryRequest
import com.sususu.wordpuzzle.infrastructure.Channel
import com.sususu.wordpuzzle.infrastructure.DictionarySearchError
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import java.io.IOException
import kotlin.reflect.full.memberProperties

interface DictionaryApiService {
    fun searchDictionary(searchDictionaryRequest: SearchDictionaryRequest): Channel
}

@Component
class DictionaryApiServiceImpl(
    val restClient: RestClient
): DictionaryApiService {
    override fun searchDictionary(searchDictionaryRequest: SearchDictionaryRequest): Channel {
        val param = searchDictionaryRequest.toQueryParam()

        val body = restClient.get()
            .uri("?${param}")
            .accept(MediaType.APPLICATION_XML)
            .retrieve()
            .body<String>()

        val xmlMapper = XmlMapper().registerKotlinModule()

        runCatching {
            return xmlMapper.readValue(body, Channel::class.java)
        }.getOrElse { exception ->
            val error = runCatching {
                xmlMapper.readValue(body, DictionarySearchError::class.java)
            }.getOrElse {
                throw IOException(exception)
            }
            throw IllegalArgumentException("DICTIONARY API ERROR: [${error.errorCode}] ${error.message}")
        }
    }

    fun SearchDictionaryRequest.toQueryParam(): String {
        return this::class.memberProperties
            .filter { it.call(this) != null }
            .joinToString("&") { "${it.name}=${it.call(this).toString()}" }
    }

}