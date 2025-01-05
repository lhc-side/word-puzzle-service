package com.sususu.wordpuzzle.client.service

import com.sususu.wordpuzzle.application.DictionaryApiServiceImpl
import com.sususu.wordpuzzle.client.dto.SearchDictionaryRequest
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import java.io.IOException
import kotlin.test.assertTrue

class DictionaryApiServiceImplTest {

    private val restClient = mockk<RestClient>()
    private val dictionaryApiService = DictionaryApiServiceImpl(restClient)

    @Test
    fun `restClient로 사전 api 조회 성공`() {
        val body = """
            <?xml version="1.0" encoding="UTF-8"?>
            <channel>
                <title>한국어 기초사전 개발 지원(Open API) - 사전 검색</title>
                <link>https://krdict.korean.go.kr</link>
                <description>한국어 기초사전 개발 지원(Open API) - 사전 검색 결과</description>
                <lastBuildDate>20250104225703</lastBuildDate>
                <total>1</total>
                <start>1</start>
                <num>100</num>
                <item>
                    <target_code>32750</target_code>
                    <word>나무</word>
                    <sup_no>0</sup_no>
                    <pronunciation>나무</pronunciation>
                    <word_grade>초급</word_grade>
                    <pos>명사</pos>
                    <link>https://krdict.korean.go.kr/kor/dicSearch/SearchView?ParaWordNo=32750</link>
                    <sense>
                        <sense_order>1</sense_order>
                        <definition>단단한 줄기에 가지와 잎이 달린, 여러 해 동안 자라는 식물.</definition>
                    </sense>
                    <sense>
                        <sense_order>2</sense_order>
                        <definition>집이나 가구 등을 만드는 데 사용하는 재목.</definition>
                    </sense>
                    <sense>
                        <sense_order>3</sense_order>
                        <definition>불을 때기 위해 베어 놓은 나무의 줄기나 가지.</definition>
                    </sense>
                </item>
            </channel>
        """.trimIndent()

        val param = SearchDictionaryRequest(
            q = "나무",
            method = null,
            type1 = null,
            type2 = null,
            level = null,
            multimedia = null,
            letterS = null,
            letterE = null,
            senseCat = null,
            subjectCat = null,
        )

        every { restClient.get().uri(any<String>()).accept(any()).retrieve().body<String>() } returns body

        val response = dictionaryApiService.searchDictionary(param)
        assertTrue(response.total >= 0)
    }

    @Test
    fun `restClient로 사전 api 조회 시 에러메시지 응답`() {
        val body = """
            <?xml version="1.0" encoding="UTF-8"?>
            <error>
            	<error_code>020</error_code>
            	<message>Unregistered key</message>
            </error>
        """.trimIndent()

        val param = SearchDictionaryRequest(
            q = "나무",
            method = null,
            type1 = null,
            type2 = null,
            level = null,
            multimedia = null,
            letterS = null,
            letterE = null,
            senseCat = null,
            subjectCat = null,
        )

        every { restClient.get().uri(any<String>()).accept(any()).retrieve().body<String>() } returns body

        val error = assertThrows<IllegalArgumentException> {
            dictionaryApiService.searchDictionary(param)
        }
        println(error.message)
    }


    @Test
    fun `restClient로 사전 api 조회 시 xml 파싱 에러`() {
        val body = """
            <?xml version="1.0" encoding="UTF-8"?>
            <channel>
                <error_test>test</error_test>
            </channel>
        """.trimIndent()

        val param = SearchDictionaryRequest(
            q = "나무",
            method = null,
            type1 = null,
            type2 = null,
            level = null,
            multimedia = null,
            letterS = null,
            letterE = null,
            senseCat = null,
            subjectCat = null,
        )

        every { restClient.get().uri(any<String>()).accept(any()).retrieve().body<String>() } returns body

        val error = assertThrows<IOException> {
            dictionaryApiService.searchDictionary(param)
        }
        println(error.message)
    }
}