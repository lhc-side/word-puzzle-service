package com.sususu.wordpuzzle.client.service

import com.sususu.wordpuzzle.client.dto.SearchDictionaryRequest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DictionaryApiServiceImplTest {
    @Autowired
    private lateinit var dictionaryApiService: DictionaryApiService

    @Test
    fun `restClient로 사전 api 조회 성공`() {
        val param = SearchDictionaryRequest(
            key = "6A1BE7BA4A17F36760A982858336E561",
            q = "나무",
            start = 1,
            num = 10,
            sort = "dict",
            advanced = "n",
            target = null,
            method = null,
            type1 = null,
            type2 = null,
            level = null,
            pos = null,
            multimedia = null,
            letter_s = null,
            letter_e = null,
            sense_cat = null,
            subject_cat = null,
        )
        dictionaryApiService.searchDictionary(param)

    }
}