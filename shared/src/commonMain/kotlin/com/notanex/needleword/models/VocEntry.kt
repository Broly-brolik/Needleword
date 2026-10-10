package com.notanex.needleword.models

import kotlinx.serialization.Serializable

@Serializable
data class VocEntry(
    val id: String,
    val term: String,
    val translation: String,
    val phonetic: String? = null,
    val example: String? = null,
    val emphasized: Boolean = false,
    val extras: Map<String, String> = emptyMap(),
)