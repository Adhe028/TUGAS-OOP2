package com.ade.oop2.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Entity annotation to specify the table's name
@Entity(tableName = "guru")
//Parcelable annotation to make parcelable object
@Parcelize
data class Guru(
    //PrimaryKey annotation to declare primary key
    //ColumnInfo annotation to specify the column's name
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "nama") var nama: String = "",
    @ColumnInfo(name = "nip") var nip: String = "",
    @ColumnInfo(name = "ngajar") var ngajar: String = ""

) : Parcelable {
}