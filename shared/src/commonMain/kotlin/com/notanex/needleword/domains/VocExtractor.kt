package com.notanex.needleword.domains

import com.notanex.needleword.models.VocEntry

interface VocExtractor {
    suspend fun extract(image: ByteArray): List<VocEntry>
}