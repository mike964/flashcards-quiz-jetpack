package com.example.falshcardsquiz.components


import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.falshcardsquiz.FlashcardsViewModel

@Composable
fun AnswerOptions(
    options: List<Card>,
    correctAnswer: Card,
    count: Int,
    vm: FlashcardsViewModel = viewModel(),
) {
    var options_ = options.slice(0..3).shuffled()

    options_.forEach { opt ->
        Button(
            {
                Log.d("xxc", opt.toString())
                Log.d("xxc", correctAnswer.toString())

                if (count == 9) {
//                        count = 0
                    vm.resetCounter()
                } else {
//                        count++
                    vm.incrementCounter()
                    if (correctAnswer.id == opt.id) {
                        vm.incrementScore()
                    }
                }

            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F5C95), // Background color
                contentColor = Color.White, // Text/icon color
            ), modifier = Modifier.width(160.dp)
        ) { Text(text = opt.name) }
        Spacer(modifier = Modifier.height(8.dp))
    }
}