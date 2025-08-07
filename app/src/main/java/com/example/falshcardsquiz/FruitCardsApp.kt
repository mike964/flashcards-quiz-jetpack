package com.example.falshcardsquiz

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.falshcardsquiz.components.AnswerOptions
import com.example.falshcardsquiz.components.Card
import com.example.falshcardsquiz.components.ImageCard
import com.example.falshcardsquiz.components.LinearProgressBar

@SuppressLint("UnrememberedMutableState")
@Composable
fun FruitCardsApp(cards: List<Card>) {


    // State to hold the counter value
    var count by remember { mutableStateOf(0) }
    val currentImageResId by remember { mutableStateOf(R.drawable.apple) }

    val possibleAnswers = cards.map { it.name }.shuffled().slice(0..2)
    var answerOptions: MutableList<String> = mutableListOf()
    answerOptions.addAll(possibleAnswers)
    answerOptions.add(cards[count].name)

    Log.d("xxc", possibleAnswers.toString())
    Log.d("xxc", answerOptions.toString())


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            LinearProgressBar(
                (count + 1) / cards.size.toFloat()
            )

            Text(count.toString())
            Spacer(modifier = Modifier.padding(8.dp))
//            Text((count / cards.size.toFloat()).toString())
//            Text((count+1).toString()+"/" + (shuffledCards.size).toString(), modifier = Modifier.padding(8.dp))

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


            AnswerOptions(answerOptions)
        }
    }
}