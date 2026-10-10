package com.notanex.needleword

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.notanex.needleword.data.extract.FakeVocExtractor
import com.notanex.needleword.ui.reviews.ReviewScreen


@Composable
@Preview
fun App() {
    MaterialTheme {
        val extractor = remember { FakeVocExtractor() }
        ReviewScreen(extractor)
    }
}