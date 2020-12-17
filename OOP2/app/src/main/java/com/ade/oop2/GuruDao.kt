package com.ade.oop2

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface GuruDao {
    @Query("SELECT * FROM guru")
    fun getAll(): List<Guru>

    @Query("SELECT * FROM guru WHERE nipy IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Guru>

    @Query("SELECT * FROM guru WHERE nama LIKE :nama AND " +
            "mengajar LIKE :mengajar LIMIT 1")
    fun findByName(nama: String, mengajar: String): Guru

    @Insert
    fun insertAll(vararg guru: Guru)

    @Delete
    fun delete(guru: Guru)
}