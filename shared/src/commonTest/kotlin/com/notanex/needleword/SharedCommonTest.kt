package com.notanex.needleword

import com.notanex.needleword.models.VocEntry
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SharedCommonTest {

    @Test
    fun example() {
        assertEquals(3, 1 + 2)
    }
}

class VocabEntryTest {
    @Test
    fun parsesEntryWithMissingOptionalFields() {
        val json = """{"id":"1","term":"bias (n)","translation":"préjugé"}"""
        val entry = Json.decodeFromString<VocEntry>(json)
        assertEquals(null, entry.phonetic)
        assertTrue(entry.extras.isEmpty())
    }
}