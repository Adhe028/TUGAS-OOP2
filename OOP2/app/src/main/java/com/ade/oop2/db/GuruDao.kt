package com.ade.oop2.db


import androidx.room.*
import com.ade.oop2.model.Guru

@Dao
interface GuruDao {

    @Insert
    fun insert(guru: Guru)

    @Update
    fun update(guru: Guru)

    @Delete
    fun delete(guru: Guru)

    @Query("SELECT * FROM guru")
    fun getAll() : List<Guru>

    @Query("SELECT * FROM guru WHERE id = :id")
    fun getById(id: Int) : List<Guru>
}