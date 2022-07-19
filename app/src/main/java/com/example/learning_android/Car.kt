package com.example.learning_android

sealed class Car(val num : String){
    class BMW(num : String) : Car(num){
        var test  = 0
    }
    object Audinum : Car("num")
    object Mercedes: Car("sdfsdf")
}
