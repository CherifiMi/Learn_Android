package com.example.learning_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learning_android.ui.theme.Learning_AndroidTheme

class MainActivity : ComponentActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            viewModel = viewModel()

            Learning_AndroidTheme {
                App()
            }
        }
    }

    @Composable
    fun App() {
        
        val time = viewModel.coundDownFlow.collectAsState(initial = 10)
        
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = time.value.toString(),
                fontSize = 30.sp
            )

        }
        
        

    }
}

