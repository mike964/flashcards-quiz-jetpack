package com.example.falshcardsquiz.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnswerOptions(options:List<String>) {
    options.forEach { opt ->
        Text(text = opt)
        Spacer(modifier = Modifier.height(8.dp))
    }
}