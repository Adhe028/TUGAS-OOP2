package com.ade.oop2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "guru")
data class Guru(
    @PrimaryKey val nipy: Int,
    @ColumnInfo(name = "nama") val nama: String?,
    @ColumnInfo(name = "mengajar") val mengajar: String?
)