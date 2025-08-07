package com.example.falshcardsquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextLong

// # SIMPLE MVVM EXAMPLE COUNTER APP
data class UserData(
    var name: String,
    var age: Int,
)

class UserRepository {
    // # Mock remote api
    suspend fun fetchUserData(): UserData {
        delay(3000)
        return UserData("Jacki Chon", 25)
    }
}

class HomeViewModel : ViewModel() {
    val userRepository: UserRepository = UserRepository()
    private val _backgroundColor = MutableLiveData<Long>( 0xFF829A5A )
    val backgroundColor: LiveData<Long> = _backgroundColor

    fun updateBackgroundColor(newColor: Long) {
        _backgroundColor.value = newColor
    }
    fun updateBackgroundColorRandomly(){
        _backgroundColor.value = Random.nextLong(0xFFFFFFFF)
    }


    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> = _userData

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getUserData() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val userResult = userRepository.fetchUserData()
            _userData.postValue(userResult)
            _isLoading.postValue(false)
        }
    }
}

// # UI
@Composable
fun SimpleMvvmApp(modifier: Modifier = Modifier, vm: HomeViewModel = viewModel()) {

    val userData = vm.userData.observeAsState()
    val isLoading = vm.isLoading.observeAsState()
    val bgColor = vm.backgroundColor.observeAsState() // Observe LiveData

    Column(
        modifier = modifier.fillMaxSize().background(Color(bgColor.value!!)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { vm.getUserData() }) {
            Text("Get data")
        }
        Button(onClick = { vm.updateBackgroundColor( 0xFFA87959)  }) {
            Text("Change Background")
        }
        Button(onClick = { vm.updateBackgroundColorRandomly() }) {
            Text("Pick random color")
        }

        if (isLoading.value == true) {
            CircularProgressIndicator()
        } else {
            userData.value?.name?.let {
                // if user data not null and has name show text
                Text("Name :$it")
            }
        }

    }
}