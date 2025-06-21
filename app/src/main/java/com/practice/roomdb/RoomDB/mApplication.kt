package com.practice.roomdb.RoomDB

import android.app.Application
import androidx.room.Room

class mApplication: Application() {

    lateinit var database: Database
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "data.db"
        ).build()
    }


}