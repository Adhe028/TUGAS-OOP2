package com.ade.oop2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Siswa::class), version = 1)
abstract class SiswaRoomDatabase : RoomDatabase() {
    abstract fun siswaDao(): SiswaDao

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
        applicationContext,
        SiswaRoomDatabase::class.java, "APPDB"
    ).build()
}