package com.example.unittesting.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DATA")
class Data(
    var name: String?,
    var email: String?,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null)
{
    fun getData(): Data {
        return Data(name, email, id)
    }
}