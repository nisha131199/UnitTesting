package com.example.unittesting.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unittesting.models.Data
import com.example.unittesting.storage.Repository
import kotlinx.coroutines.runBlocking

class MyViewModel (private val repository: Repository) : ViewModel() {

    init {
        loadData()
    }

    fun loadData(): List<Data>? {
        try {
            runBlocking {
                repository.getData()
            }.also {
                return it
            }
        } catch (e: Exception) {
            println(e.message.toString())
            return null
        }
    }

}