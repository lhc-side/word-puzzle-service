package com.sususu.wordpuzzle.client.service

import com.sususu.wordpuzzle.application.DictionaryApiService
import com.sususu.wordpuzzle.client.dto.SearchDictionaryRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertTrue

@SpringBootTest
class DictionaryApiServiceImplTest {
    @Autowired
    private lateinit var dictionaryApiService: DictionaryApiService

    @Test
    fun `restClient로 사전 api 조회 성공`() {
        val param = SearchDictionaryRequest(
            q = "나무",
            method = null,
            type1 = null,
            type2 = null,
            level = null,
            multimedia = null,
            letter_s = null,
            letter_e = null,
            sense_cat = null,
            subject_cat = null,
        )

        val response = dictionaryApiService.searchDictionary(param)
        assertTrue(response.total >= 0)
    }

    @Test
    fun `restClient로 사전 api 조회 시 에러메시지 응답`() {
        val param = SearchDictionaryRequest(
            q = "나무",
            method = null,
            type1 = null,
            type2 = null,
            level = null,
            multimedia = null,
            letter_s = null,
            letter_e = null,
            sense_cat = null,
            subject_cat = null,
        )

        val error = assertThrows<IllegalArgumentException> {
            dictionaryApiService.searchDictionary(param)
        }
        println(error.message)
    }


//    @Test
//    fun `restClient로 사전 api 조회 시 xml 파싱 에러`() {
//        val param = SearchDictionaryRequest(
//            q = "나무",
//            method = null,
//            type1 = null,
//            type2 = null,
//            level = null,
//            multimedia = null,
//            letter_s = null,
//            letter_e = null,
//            sense_cat = null,
//            subject_cat = null,
//        )
//
//        assertThrows<IOException> {
//            dictionaryApiService.searchDictionary(param)
//        }
//    }
}