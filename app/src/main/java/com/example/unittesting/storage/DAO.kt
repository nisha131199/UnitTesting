package com.example.unittesting.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.unittesting.models.Data
import java.util.Optional

@Dao
interface DAO {
    @Insert
    suspend fun insertData(data: Data)

    @Insert
    suspend fun insertAllData(list: List<Data>)

    @Query("select * from DATA")
    suspend fun getAllData(): List<Data>

    @Delete
    suspend fun deleteData(data: Data)
}