package com.notanex.needleword.ui.reviews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.notanex.needleword.domains.VocExtractor
import com.notanex.needleword.models.VocEntry

@Composable
fun ReviewScreen(extractor: VocExtractor) {
    var entries by remember { mutableStateOf<List<VocEntry>?>(null) }

    LaunchedEffect(Unit) {
        entries = extractor.extract(ByteArray(0)) // real image comes later
    }

    val list = entries
    if (list == null) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            Modifier.fillMaxSize().safeContentPadding(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(list, key = { it.id }) { entry ->
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(12.dp)) {
                        Text(entry.term, style = MaterialTheme.typography.titleMedium)
                        Text(entry.translation)
                        entry.phonetic?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                        entry.extras.forEach { (k, v) -> Text("$k: $v") }
                    }
                }
            }
        }
    }
}