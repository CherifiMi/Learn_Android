package com.example.learning_android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.learning_android.ui.theme.Learning_AndroidTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {

    var color = mutableStateOf(0xFFBB86FC)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Learning_AndroidTheme {
                Box(modifier = Modifier.background(Color(color.value)).fillMaxSize())
            }
        }

        var x = 0

        GlobalScope.launch (Dispatchers.Main){
            launch {
                for (i in 1..10){
                    x =+ i
                    Log.d("HILLO","111  " + x.toString())
                    delay(1000L)
                }

            }
            launch {
                for (i in 1..10){
                    x =+ i
                    Log.d("HILLO", "222  " +x.toString())
                }
            }
            launch {
                for (i in 1..10){
                    x =+ i
                    Log.d("HILLO", "333  " +x.toString())
                }
            }
            launch {
                for (i in 1..10){
                    x =+ i
                    Log.d("HILLO", "444  " +x.toString())
                }
            }
        }

        Log.d("HILLO", x.toString())

    }



}

