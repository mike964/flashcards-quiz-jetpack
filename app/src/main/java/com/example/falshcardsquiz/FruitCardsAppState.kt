package com.example.falshcardsquiz

import androidx.compose.runtime.Composable

// # This is using state hoisting
@Composable
fun FruitCardsAppState(){
    val fruits = listOf(
        com.example.falshcardsquiz.components.Card("Apple", R.drawable.apple),
        com.example.falshcardsquiz.components.Card("Banana", R.drawable.banana),
        com.example.falshcardsquiz.components.Card("Carrot", R.drawable.carrot),
        com.example.falshcardsquiz.components.Card("Apricot", R.drawable.apricot),
        com.example.falshcardsquiz.components.Card("Avocado", R.drawable.avocado),
        com.example.falshcardsquiz.components.Card("Cherry", R.drawable.cherry),
        com.example.falshcardsquiz.components.Card("Grape", R.drawable.grape),
        com.example.falshcardsquiz.components.Card("Kiwi", R.drawable.kiwi),
        com.example.falshcardsquiz.components.Card("Lemon", R.drawable.lemon),
        com.example.falshcardsquiz.components.Card("Strawberry", R.drawable.strawberry),
    )
    val animals = listOf(
        com.example.falshcardsquiz.components.Card("Cat", R.drawable.cat),
        com.example.falshcardsquiz.components.Card("Dog", R.drawable.dog),
        com.example.falshcardsquiz.components.Card("Butterfly", R.drawable.butterfly),
        com.example.falshcardsquiz.components.Card("Cobra", R.drawable.cobra),
        com.example.falshcardsquiz.components.Card("Cow", R.drawable.cow),
        com.example.falshcardsquiz.components.Card("Crab", R.drawable.crab),
        com.example.falshcardsquiz.components.Card("Dinosaur", R.drawable.dinosaur),
        com.example.falshcardsquiz.components.Card("Elephant", R.drawable.elephant),
        com.example.falshcardsquiz.components.Card("Fish", R.drawable.fish),
        com.example.falshcardsquiz.components.Card("Flamingo", R.drawable.flamingo),
        com.example.falshcardsquiz.components.Card("Hen", R.drawable.hen),
        com.example.falshcardsquiz.components.Card("Lion", R.drawable.lion),
        com.example.falshcardsquiz.components.Card("Mouse", R.drawable.mouse),
        com.example.falshcardsquiz.components.Card("Octopus", R.drawable.octopus),
        com.example.falshcardsquiz.components.Card("Panda", R.drawable.panda),
        com.example.falshcardsquiz.components.Card("Penguin", R.drawable.penguin),
        com.example.falshcardsquiz.components.Card("Perch", R.drawable.perch),
        com.example.falshcardsquiz.components.Card("Rabbit", R.drawable.rabbit),
        com.example.falshcardsquiz.components.Card("Shark", R.drawable.shark),
        com.example.falshcardsquiz.components.Card("Sheep", R.drawable.sheep),
        com.example.falshcardsquiz.components.Card("Snail", R.drawable.snail),
        com.example.falshcardsquiz.components.Card("Swallow", R.drawable.swallow),
        com.example.falshcardsquiz.components.Card("Turtle", R.drawable.turtle),
        com.example.falshcardsquiz.components.Card("Whale", R.drawable.whale),
        com.example.falshcardsquiz.components.Card("Zebra", R.drawable.zebra),
    )

    var cards = fruits.plus(animals)
    val shuffledCards = cards.shuffled().slice(0..9)

    FruitCardsApp(shuffledCards)
}