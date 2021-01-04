package com.ade.oop2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ade.oop2.model.Guru
import com.ade.oop2.model.Siswa

@Database(entities = [Guru::class], version = 1, exportSchema = false)
abstract class GuruRoomDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: GuruRoomDatabase? = null

        fun getDatabase(context: Context): GuruRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GuruRoomDatabase::class.java,
                    "guru_db"
                )
                    .allowMainThreadQueries() //allows Room to executing task in main thread
                    .fallbackToDestructiveMigration() //allows Room to recreate table if no migrations found
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun getGuruDao() : GuruDao
}