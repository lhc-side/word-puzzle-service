package com.sususu.wordpuzzle.client.service

import com.sususu.wordpuzzle.client.dto.SearchDictionaryRequest
import com.sususu.wordpuzzle.client.dto.SearchDictionaryResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

interface DictionaryApiService {
    fun searchDictionary(searchDictionaryRequest: SearchDictionaryRequest): SearchDictionaryResponse
}

@Component
class DictionaryApiServiceImpl(
    val restClient: RestClient
): DictionaryApiService {
    override fun searchDictionary(searchDictionaryRequest: SearchDictionaryRequest): SearchDictionaryResponse {
        val param = searchDictionaryRequest.toQueryParam()
        var responseSpec = restClient.get()
            .uri(param)
            .retrieve()

        TODO("")
    }
    fun SearchDictionaryRequest.toQueryParam(): String {
        return this::class.members
            .filter { it.name != "copy" && it.name != "equals" && it.name != "hashCode" && it.name != "toString" }
            .filter { it.call(this) != null } // null인 필드 제외
            .joinToString("&") { member ->
                val key = member.name
                val value = member.call(this).toString()
                "${key}=${value}"
            }
    }

//    fun SearchDictionaryRequest.toQueryParam(): String {
//        return this::class.members
//            .filter { it.call(this) != null }
//            .joinToString("&") {
//                "${it.name}=${it.call(this).toString()}"
//            }
//    }
}