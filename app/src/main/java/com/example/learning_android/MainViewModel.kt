package com.example.learning_android

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    val countDownFlow = flow {

        val startval = 100

        var nowval = startval
        emit(startval)
        while (nowval > 0) {
            delay(1000L)
            nowval--
            emit(nowval)
        }

    }

    init {
        collectFlow()
    }

    private fun collectFlow() {
        viewModelScope.launch {
            val count = countDownFlow
                .filter {
                    it%2 == 0
                }
                .map {
                    it*it
                }
                .count {
                    it % 2 == 0
                }
        }
    }

}