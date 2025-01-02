package com.sususu.wordpuzzle.infrastructure

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class DictionarySearchError(
    @JacksonXmlProperty(localName = "error_code")
    val errorCode: String,
    @JacksonXmlProperty(localName = "message")
    val message: String
)