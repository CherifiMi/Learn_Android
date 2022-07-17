package com.example.learning_android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
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

    val countUpFlow = flow {

        val startval = 0

        var nowval = startval
        emit(startval)
        while (true) {
            delay(1000L)
            nowval++
            emit(nowval)
        }

    }

    init {
        collectFlow()
    }

    private fun collectFlow(){
        viewModelScope.launch {
            countUpFlow.collectLatest{time->
                delay(2000L)
                println("the time is  " + time.toString())
            }
        }
    }
}