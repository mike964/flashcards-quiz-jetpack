package com.example.falshcardsquiz

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel

//import androidx.lifecycle.viewmodel.compose.viewModel

// Counter with ViewModel Example

data class CounterUiState(val count: Int = 0)

data class Employee(
    val id: Int,
    val name: String,
    val email: String,
    val department: String,
)

class CounterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _uiState.asStateFlow()

    fun incrementCount() {
        _uiState.value = _uiState.value.copy(count = _uiState.value.count + 1)
    }

    fun decrementCount() {
        _uiState.value = _uiState.value.copy(count = _uiState.value.count - 1)
    }

    // Backing property for LiveData
    private val _users = MutableLiveData<List<String>>()
    val users: LiveData<List<String>> get() = _users

    init {
        // Simulating data loading
        loadUsers()
    }

    private fun loadUsers() {
        _users.value = listOf("Alice", "Bob", "Charlie")
    }

    fun addUser(newUser: String) {
//        _users.add(newUser)
    }

    private val employees = mutableListOf<Employee>()

    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }

    fun getEmployees() = employees
}

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val users = viewModel.users.observeAsState(emptyList())
    val employees = viewModel.getEmployees()

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: ${uiState.count}", modifier = Modifier.padding(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { viewModel.incrementCount() }) {
                Text("Increment")
            }
            Button(onClick = { viewModel.decrementCount() }) {
                Text("Decrement")
            }
        }
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = { Text("Enter name") }
        )
        Button(onClick = {
            Log.d("xxc", name)
            viewModel.addEmployee(
                Employee(id = 1, name, "ass@mail.com", "Sikdick secion")
            )
        }) {
            Text("Show")
        }
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            users.value.forEach { user ->
//                Text(text = user)
//                Spacer(modifier = Modifier.height(8.dp))
//            }
//        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            employees.forEach { user ->
                Text(text = user.name)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}