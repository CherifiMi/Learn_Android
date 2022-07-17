package com.example.learning_android

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.learning_android.ui.theme.Learning_AndroidTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    var color = mutableStateOf(0xFFBB86FC)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Learning_AndroidTheme {
                Surface(modifier = Modifier.background(Color(color.value))) {

                }
            }
        }

        //________________________________Coroutines

        GlobalScope.launch(Dispatchers.IO) {
            val netAnswar = doNetCall()
            val netAnswar2 = doNetCall2()
            Log.d("HILLOCORE", netAnswar)
            Log.d("HILLOCORE", netAnswar2)
        }

    }



    suspend fun doNetCall(): String {
        delay(3000L)
        return "This is Data"
    }
    suspend fun doNetCall2(): String {
        delay(3000L)
        return "This is Data 2"
    }
}

