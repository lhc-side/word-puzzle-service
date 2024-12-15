package com.sususu.wordpuzzle.client.dto

data class SearchDictionaryResponse(
    val channel: Channel
)

data class Channel(
    val title: String,
    val link: String,
    val description: String,
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val num: Int,
    val items: List<Item>
)

data class Item(
    val targetCode: Int,
    val word: String,
    val supNo: Int,
    val pronunciation: String,
    val wordGrade: String? = null,
    val pos: String,
    val link: String,
    val senses: List<Sense>,
    val origin: String? = null
)

data class Sense(
    val senseOrder: Int,
    val definition: String
)
