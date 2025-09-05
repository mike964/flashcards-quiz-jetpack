package com.example.falshcardsquiz.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// define setting for the quiz before start

@Composable
fun StartScreen(){

}

@Preview(showBackground = true)
@Composable
fun CheckboxMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
        Button(onClick = {}, modifier = Modifier.width(200.dp)) { Text("Animals")}
        Button(onClick = {}) { Text("Fruits")}
        Button(onClick = {}) { Text("Objects")}
        Button(onClick = {}) { Text("Mix")}

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

        Button(onClick = {},  colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue, // Sets the background color of the button
            contentColor = Color.White // Sets the color of the content (e.g., Text) inside the button
        )) {
            Text("Start")
        }

    }
}
