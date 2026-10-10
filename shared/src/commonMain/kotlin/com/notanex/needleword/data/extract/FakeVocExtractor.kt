package com.notanex.needleword.data.extract

import com.notanex.needleword.domains.VocExtractor
import com.notanex.needleword.models.VocEntry
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class FakeVocExtractor : VocExtractor {
    override suspend fun extract(image: ByteArray): List<VocEntry> {
        delay(800.milliseconds)
        return listOf(
            VocEntry(
                id = "1", term = "armed robbery (n)", translation = "vol à main armée",
                phonetic = "/ˌɑːmd ˈrɒbəri/",
                example = "Two men were found guilty of armed robbery.",
            ),
            VocEntry(
                id = "2", term = "bear", translation = "supporter",
                extras = mapOf("past" to "bore", "participle" to "borne"),
            ),
            VocEntry(
                id = "3", term = "vergessen (+A)", translation = "oublier",
                emphasized = true,
                extras = mapOf("forms" to "vergisst, vergass, hat vergessen"),
            ),
        )
    }
}