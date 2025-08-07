package com.example.falshcardsquiz

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.falshcardsquiz.components.Card
import com.example.falshcardsquiz.components.ImageCard

@Composable
fun FlashcardsChanger(cards:List<Card>   ){

    var count = 0

    ImageCard(cards[count].imageId, cards[count].name)


    Button(
        onClick = {
            if (count == 9) {
                count = 0
            } else {
                count++
            }
        },
        modifier = Modifier.padding(10.dp)
    ) { Text("Next") }

    Button(onClick = { count-- }) {
        Text("Prev")
    }
}