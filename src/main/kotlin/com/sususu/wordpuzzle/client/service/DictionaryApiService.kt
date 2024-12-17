package com.sususu.wordpuzzle.client.service

import com.sususu.wordpuzzle.client.dto.SearchDictionaryRequest
import com.sususu.wordpuzzle.client.dto.SearchDictionaryResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import kotlin.reflect.full.memberProperties

interface DictionaryApiService {
    fun searchDictionary(searchDictionaryRequest: SearchDictionaryRequest): SearchDictionaryResponse
}

@Component
class DictionaryApiServiceImpl(
    val restClient: RestClient
): DictionaryApiService {
    override fun searchDictionary(searchDictionaryRequest: SearchDictionaryRequest): SearchDictionaryResponse {
        val param = searchDictionaryRequest.toQueryParam()
        val responseSpec = restClient.get()
            .uri("?${param}")
            .accept(MediaType.APPLICATION_XML)
            .retrieve()

        val body = responseSpec.toEntity(SearchDictionaryResponse::class.java)
        TODO("")
    }

    fun SearchDictionaryRequest.toQueryParam(): String {
        return this::class.memberProperties
            .filter { it.call(this) != null }
            .joinToString("&") { "${it.name}=${it.call(this).toString()}" }
    }

}