package com.sususu.wordpuzzle.infrastructure

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class Channel(
    @JacksonXmlProperty(localName = "title")
    val title: String,
    @JacksonXmlProperty(localName = "link")
    val link: String,
    @JacksonXmlProperty(localName = "description")
    val description: String,
    @JacksonXmlProperty(localName = "lastBuildDate")
    val lastBuildDate: String,
    @JacksonXmlProperty(localName = "total")
    val total: Int,
    @JacksonXmlProperty(localName = "start")
    val start: Int,
    @JacksonXmlProperty(localName = "num")
    val num: Int,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    val items: List<Item>? = null
)

data class Item(
    @JacksonXmlProperty(localName = "target_code")
    val targetCode: String,
    @JacksonXmlProperty(localName = "word")
    val word: String,
    @JacksonXmlProperty(localName = "sup_no")
    val supNo: String,
    @JacksonXmlProperty(localName = "origin")
    val origin: String? = null,
    @JacksonXmlProperty(localName = "pronunciation")
    val pronunciation: String? = null,
    @JacksonXmlProperty(localName = "word_grade")
    val wordGrade: String? = null,
    @JacksonXmlProperty(localName = "pos")
    val pos: String,
    @JacksonXmlProperty(localName = "link")
    val link: String,
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "sense")
    val senses: List<Sense>? = null
)

data class Sense(
    @JacksonXmlProperty(localName = "sense_order")
    val senseOrder: Int,
    @JacksonXmlProperty(localName = "definition")
    val definition: String
)