package com.example.falshcardsquiz

import androidx.compose.runtime.Composable
import com.example.falshcardsquiz.components.Card

// # This is using state hoisting
@Composable
fun FruitCardsAppState(){
    val fruits = listOf(
        Card("Apple", R.drawable.apple, "35345434") ,
        Card("Banana", R.drawable.banana ,"35234434"),
        Card("Carrot", R.drawable.carrot ,"35464534"),
        Card("Apricot", R.drawable.apricot , "31235434"),
        Card("Avocado", R.drawable.avocado, "353445434"),
        Card("Cherry", R.drawable.cherry, "35487634"),
        Card("Grape", R.drawable.grape, "35434564"),
        Card("Kiwi", R.drawable.kiwi, "35433454"),
        Card("Lemon", R.drawable.lemon, "357987434"),
        Card("Strawberry", R.drawable.strawberry, "35423434"),
    )
    val animals = listOf(
        Card("Cat", R.drawable.cat , "35486734"),
        Card("Dog", R.drawable.dog , "305423434"),
        Card("Butterfly", R.drawable.butterfly , "35485634"),
        Card("Cobra", R.drawable.cobra , "354234134"),
        Card("Cow", R.drawable.cow , "3543434567"),
        Card("Crab", R.drawable.crab , "3543445734"),
        Card("Dinosaur", R.drawable.dinosaur , "354534434"),
        Card("Elephant", R.drawable.elephant , "35454234"),
        Card("Fish", R.drawable.fish , "3579853434"),
        Card("Flamingo", R.drawable.flamingo , "35498734234"),
        Card("Hen", R.drawable.hen , "35434126578"),
        Card("Lion", R.drawable.lion , "3543445678"),
        Card("Mouse", R.drawable.mouse , "35445678634"),
        Card("Octopus", R.drawable.octopus , "3578512434"),
        Card("Panda", R.drawable.panda , "354344512"),
        Card("Penguin", R.drawable.penguin , "354340012"),
        Card("Perch", R.drawable.perch , "354340486"),
        Card("Rabbit", R.drawable.rabbit, "354254634"),
        Card("Shark", R.drawable.shark , "354465434"),
        Card("Sheep", R.drawable.sheep , "3509045434"),
        Card("Snail", R.drawable.snail , "35434574534"),
        Card("Swallow", R.drawable.swallow , "364875434"),
        Card("Turtle", R.drawable.turtle , "354789234"),
        Card("Whale", R.drawable.whale , "35434324568"),
        Card("Zebra", R.drawable.zebra , "350297434"),
    )

    var cards = fruits.plus(animals)
    val shuffledCards = cards.shuffled().slice(0..9)

    FruitCardsApp(shuffledCards)
}