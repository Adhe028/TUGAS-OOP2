package com.ade.oop2.db

import androidx.room.*
import com.ade.oop2.model.Siswa

@Dao
interface SiswaDao {

    @Insert
    fun insert(siswa: Siswa)

    @Update
    fun update(siswa: Siswa)

    @Delete
    fun delete(siswa: Siswa)

    @Query("SELECT * FROM siswa")
    fun getAll() : List<Siswa>

    @Query("SELECT * FROM siswa WHERE id = :id")
    fun getById(id: Int) : List<Siswa>
}