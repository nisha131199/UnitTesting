package com.example.unittesting.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.unittesting.models.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class MyRoom : RoomDatabase() {

    abstract fun userDao(): DAO

    companion object {
        var roomI: MyRoom? = null

        fun getDatabase(context: Context): MyRoom {
            if (roomI == null)
                roomI = databaseBuilder(
                    context.applicationContext,
                    MyRoom::class.java,
                    "DATABASE"
                )
                    .build()
            return roomI!!
        }
    }
}