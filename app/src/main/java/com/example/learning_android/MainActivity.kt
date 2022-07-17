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
                Box(
                    modifier = Modifier
                        .background(Color(color.value))
                        .fillMaxSize()
                )
            }
        }

        val job = GlobalScope.launch {
            if(isActive){
                fab(40)
            }
        }

        runBlocking {
            delay(2000L)
            job.cancel()
            write(tag = "DOOONE",s = "job doneeeeeee")
        }

    }

    fun write(tag: String = "HELLO_TESTING",s: String) {
        Log.d(tag, s)
    }

    fun fab(n: Int): Int{
        write(s = n.toString())
        return if (n == 0) 0
        else if (n == 1) 1
        else fab(n - 1) + fab(n-2)
    }

}

