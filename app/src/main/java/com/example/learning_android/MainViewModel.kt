package com.example.learning_android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var num: Int by mutableStateOf(savedStateHandle.get("num") ?: 0)
        private set

    fun numup() {
        num++
        savedStateHandle.set("num", num)
    }
}