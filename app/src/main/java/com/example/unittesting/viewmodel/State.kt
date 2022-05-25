package com.example.unittesting.viewmodel

import com.example.unittesting.models.Data

open class State {
    data class SUCCESS(val listOfData: List<Data>) : State()
    data class FAILURE(val message: String) : State()
}