package com.sususu.wordpuzzle.client.dto

data class SearchDictionaryRequest(
    val q: String,
    val method: String?,
    val type1: String?,
    val type2: String?,
    val level: String?,
    val multimedia: Int?,
    val letterS: Int?,
    val letterE: Int?,
    val senseCat: Int?,
    val subjectCat: Int?
) {
    fun toQueryParam(): String {
        return listOfNotNull(
            "q=$q",
            method?.let { "method=$it" },
            type1?.let { "type1=$it" },
            type2?.let { "type2=$it" },
            level?.let { "level=$it" },
            multimedia?.let { "multimedia=$it" },
            letterS?.let { "letter_s=$it" },
            letterE?.let { "letter_e=$it" },
            senseCat?.let { "sense_cat=$it" },
            subjectCat?.let { "subject_cat=$it" }
        ).joinToString("&")
    }
}
