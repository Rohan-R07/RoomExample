package com.practice.roomdb.RoomDB

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Data(

    val name:String ,
    val age: String,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

)
