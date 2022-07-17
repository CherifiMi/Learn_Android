package com.example.learning_android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel()
    : ViewModel() {

        val coundDownFlow = flow {

            val startval = 100

            var nowval = startval
            emit(startval)
            while(nowval>0){
                delay(1000L)
                nowval --
                emit(nowval)
            }

        }

}