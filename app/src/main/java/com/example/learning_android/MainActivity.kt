package com.example.learning_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learning_android.ui.theme.Learning_AndroidTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
            Learning_AndroidTheme {
                Box(modifier = Modifier.fillMaxSize()){
                    Button(onClick = { viewModel.numup() }) {
                        Text(text = "you clicked me ${viewModel.num} times")
                    }
                }
            }
        }


        




    }





}

