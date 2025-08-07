package com.example.falshcardsquiz

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun StateTestScreen(){
    Log.d("xxc", "StateTestScreen()-----")
    var name by rememberSaveable { mutableStateOf("") }
    // rememberSaveable persist when rotate device

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText(name)
        MyTextField(name, onNameChange = {name=it} )
    }
}

@Composable
fun MyText(name: String){
    Log.d("xxc", "MyText()-----")
    Text("Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name: String, onNameChange:(String)->Unit){
    Log.d("xxc", "MyTextField()-----")
//    var name = ""
    var name2 by remember { mutableStateOf("") }

    Log.d("xxc", name)

    OutlinedTextField(
        value=name,
        onValueChange = {
//            Log.d("xxc", it)
//            name = it
            onNameChange(it)
        },
        label = {Text("Enter name")}
    )
    OutlinedTextField(
        value = name2,
        onValueChange = {
          name2=it
        },
        label = {Text("Enter Second")}
    )
}