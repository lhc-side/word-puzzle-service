package com.sususu.wordpuzzle.client.dto

data class SearchDictionaryRequest(
    val q: String,
    val method: String?,
    val type1: String?,
    val type2: String?,
    val level: String?,
    val multimedia: Int?,
    val letter_s: Int?,
    val letter_e: Int?,
    val sense_cat: Int?,
    val subject_cat: Int?
)
