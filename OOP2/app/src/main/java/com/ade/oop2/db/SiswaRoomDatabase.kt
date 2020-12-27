package com.ade.oop2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ade.oop2.model.Siswa

//Database annotation to specify the entities and set version
@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class SiswaRoomDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: SiswaRoomDatabase? = null

        fun getDatabase(context: Context): SiswaRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SiswaRoomDatabase::class.java,
                    "siswa_db"
                )
                    .allowMainThreadQueries() //allows Room to executing task in main thread
                    .fallbackToDestructiveMigration() //allows Room to recreate table if no migrations found
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun getSiswaDao() : SiswaDao
}
