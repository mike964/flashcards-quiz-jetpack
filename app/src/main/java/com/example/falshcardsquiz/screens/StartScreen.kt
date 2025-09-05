package com.example.falshcardsquiz.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// define setting for the quiz before start


@Composable
fun StartScreen(navController: NavHostController) {


    Column(
        modifier = Modifier.fillMaxWidth(), // Occupy the maximum available width
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Quiz App")
        Spacer(modifier = Modifier.height(90.dp))

        CheckboxMinimalExample()

        Button(
            onClick = { navController.navigate("quiz") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, // Sets the background color of the button
                contentColor = Color.White // Sets the color of the content (e.g., Text) inside the button
            )
        ) {
            Text("Start")
        }
        Button(onClick = {
            navController.navigate("quiz-end")
        }) {
            Text("Quiz End Screen")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun CheckboxMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(12.dp)) {
        Button(onClick = {}, modifier = Modifier.width(200.dp)) {
            Text("Animals")
        }

        OptionItem("Animals")
        OptionItem("Fruits")
        OptionItem("Objects")
        OptionItem("Mix")

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Timer"
            )
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }

        Text(
            if (checked) "Checkbox is checked" else "Checkbox is unchecked"
        )

    }
}

@Composable
fun OptionItem(text: String, onClick: () -> Unit = {}) {
    Button(onClick = {}, modifier = Modifier.width(200.dp)) {
        Text(text)
    }
}