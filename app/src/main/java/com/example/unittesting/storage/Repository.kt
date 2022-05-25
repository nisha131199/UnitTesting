package com.example.unittesting.storage

import android.content.Context
import com.example.unittesting.models.Data

class Repository(context: Context) {
    private val dao = MyRoom.getDatabase(context).userDao()

    suspend fun insert(data: Data) {
        dao.insertData(data)
    }

    suspend fun insertAllData(list: List<Data>) {
        dao.insertAllData(list)
    }

    suspend fun getData(): List<Data> {
        return dao.getAllData()
    }

    suspend fun delete(data: Data) {
        dao.deleteData(data)
    }
}