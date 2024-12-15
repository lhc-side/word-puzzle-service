package com.sususu.wordpuzzle.client.dto

data class SearchDictionaryRequest(
    val key: String,
    val q: String,
    val start: Int?,
    val num: Int?,
    val sort: String?,
    val advanced: String,
    val target: Int?,
    val method: String?,
    val type1: String?,
    val type2: String?,
    val level: String?,
    val pos: Int?,
    val multimedia: Int?,
    val letter_s: Int?,
    val letter_e: Int?,
    val sense_cat: Int?,
    val subject_cat: Int?
)
