package com.example.falshcardsquiz.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

// Show score when quiz ends.
@Composable
fun QuizEndScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(), // Makes the column fill the available space
        verticalArrangement = Arrangement.Center, // Centers children vertically
        horizontalAlignment = Alignment.CenterHorizontally // Centers children horizontally
    ) {
        Text(text = "QuizEndScreen")
        Button(onClick = {
            navController.navigate("start")
        }) {
           Text( "Start Again")
        }
    }
}