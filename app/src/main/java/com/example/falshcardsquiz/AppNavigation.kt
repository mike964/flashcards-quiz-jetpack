package com.example.falshcardsquiz

import androidx.compose.runtime.Composable


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.falshcardsquiz.screens.QuizScreen
import com.example.falshcardsquiz.screens.StartScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start") {
//        composable("home") {
//            HomeScreen(onNavigateToDetail = { navController.navigate("detail") })
//        }
        composable("start") {
            StartScreen(onNavigateToQuiz = { navController.navigate("quiz") })
        }
        composable("quiz") {
            QuizScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}