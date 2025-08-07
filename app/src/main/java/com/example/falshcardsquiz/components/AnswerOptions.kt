package com.example.falshcardsquiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnswerOptions(options:List<String>) {
    options.forEach { opt ->

        Button({},    colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3F5C95), // Background color
            contentColor = Color.White, // Text/icon color
        ), modifier = Modifier.width(160.dp)) { Text(text = opt) }
        Spacer(modifier = Modifier.height(8.dp))
    }
}