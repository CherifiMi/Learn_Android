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
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {

    var color = mutableStateOf(0xFFBB86FC)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Learning_AndroidTheme {
                Box(
                    modifier = Modifier
                        .background(Color(color.value))
                        .fillMaxSize()
                )
            }
        }


        GlobalScope.launch{

            val time = measureTimeMillis {
                var a1: String? = null
                var a2: String? = null

                val job1 = launch { a1 = netCall() }
                val job2 = launch { a2 = netCall2() }

                job1.join()
                job2.join()
            }
            write(time.toString())

        }



    }

    suspend fun netCall(): String{
        delay(3000L)
        return "YOU GOT MAIL ..."
    }
    suspend fun netCall2(): String{
        delay(3000L)
        return "YOU GOT MAIL 2 ..."
    }

    fun write(s: String, tag: String = "HELLO_TESTING") {
        Log.d(tag, s)
    }



}

