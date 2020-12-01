package com.ade.oop2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SiswaDao {
    @Query("SELECT * FROM siswa")
    fun getAll(): List<Siswa>

    @Query("SELECT * FROM siswa WHERE nis IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Siswa>

    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama AND " +
            "prodi LIKE :prodi LIMIT 1")
    fun findByName(nama: String, kelas: String): Siswa

    @Insert
    fun insertAll(vararg siswa: Siswa)

    @Delete
    fun delete(siswa: Siswa)
}