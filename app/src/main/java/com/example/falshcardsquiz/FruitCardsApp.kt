package com.example.falshcardsquiz

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.falshcardsquiz.components.AnswerOptions
import com.example.falshcardsquiz.components.Card
import com.example.falshcardsquiz.components.ImageCard
import com.example.falshcardsquiz.components.LinearProgressBar

@SuppressLint("UnrememberedMutableState")
@Composable
fun FruitCardsApp(cards: List<Card>,  viewModel: FlashcardsViewModel = viewModel()) {
    // # import view model
    val uiState by viewModel.uiState.collectAsState()
    val count = uiState.count

    // State to hold the counter value
//    var count by remember { mutableIntStateOf(0) }
    val currentImageResId by remember { mutableStateOf(R.drawable.apple) }

    val possibleAnswers: List<Card> = cards.shuffled().slice(0..3)
    val correctAnswer = cards[count]
    var answerOptions: MutableList<Card> = mutableListOf()
    answerOptions.addAll(possibleAnswers)

    // # Check if the answer card exist
//    val hasApple = myList.contains("apple") // true

val hasAnswer = possibleAnswers.contains(correctAnswer)

    if(!hasAnswer) {
        answerOptions.add(0, correctAnswer)
    }

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

            Text((count+1).toString())
            Spacer(modifier = Modifier.padding(8.dp))
//            Text((count / cards.size.toFloat()).toString())
//            Text((count+1).toString()+"/" + (shuffledCards.size).toString(), modifier = Modifier.padding(8.dp))

            ImageCard(cards[count].imageId, cards[count].name)

            Button(
                onClick = {
                    if (count == 9) {
//                        count = 0
                        viewModel.resetCounter()
                    } else {
//                        count++
                        viewModel.incrementCounter()
                        viewModel.incrementScore()
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) { Text("Next") }

//            Button(onClick = { count-- }) {
//                Text("Prev")
//            }


            AnswerOptions(answerOptions, correctAnswer)



            Text("Score: ${uiState.score}")
        }
    }
}