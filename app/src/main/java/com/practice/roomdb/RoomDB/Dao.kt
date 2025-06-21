package com.practice.roomdb.RoomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {

    @Upsert
    suspend fun upserData(data: Data)

    @Delete
    suspend fun deleteData(data: Data)


    @Query("SELECT * FROM data ORDER BY age ASC")
    fun getData() : Flow<List<Data>>

}