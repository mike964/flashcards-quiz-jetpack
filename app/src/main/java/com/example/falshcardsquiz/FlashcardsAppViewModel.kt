package com.example.falshcardsquiz

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Calculate score here
data class GameUiState (
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 1,
    val count : Int = 0 ,  // cards counter
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)

class FlashcardsViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun incrementCounter() {
        _uiState.update { currentState ->
            currentState.copy(count = currentState.count + 1)
        }
    }
    fun resetCounter() {
        _uiState.update { currentState ->
            currentState.copy(count = 0 , score = 0 )
        }
    }
    fun incrementScore() {
        _uiState.update { currentState ->
            currentState.copy(score = currentState.score + 10)
        }
    }
}