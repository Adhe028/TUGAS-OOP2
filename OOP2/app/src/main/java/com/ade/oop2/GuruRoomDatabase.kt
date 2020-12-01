package com.ade.oop2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Guru::class), version = 1)
abstract class GuruRoomDatabase : RoomDatabase() {
    abstract fun guruDao(): GuruDao

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
        applicationContext,
        GuruRoomDatabase::class.java, "APPDB"
    ).build()
}