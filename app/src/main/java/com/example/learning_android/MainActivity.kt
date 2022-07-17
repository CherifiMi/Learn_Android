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


        val job = GlobalScope.launch (Dispatchers.IO){
            repeat(5){
                write("still running...")
                delay(1000L)
            }
        }

        runBlocking {
            delay(2000L)
            job.cancel()
            write("DONE")
        }

    }

    fun write(s: String){
        Log.d("HELLO_TESTING", s)
    }

}

