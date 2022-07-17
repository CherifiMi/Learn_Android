package com.example.learning_android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var num: Int by mutableStateOf(0)
        private set
    fun numup(){
        num++
    }
}