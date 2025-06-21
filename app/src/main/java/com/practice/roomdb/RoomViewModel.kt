package com.practice.roomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.practice.roomdb.RoomDB.Data
import com.practice.roomdb.RoomDB.mApplication
import kotlinx.coroutines.launch

class RoomViewModel(app: Application) : AndroidViewModel(app){

    private val db = (app as mApplication).database.dao()

    val user = db.getData()


    fun upserData(data: Data){
        viewModelScope.launch {
            db.upserData(data)
        }
    }

    fun deleteData(data: Data){
        viewModelScope.launch {
            db.deleteData(data)
        }
    }

    fun updateUser(data: Data, newName: String, newAge: String) {
        viewModelScope.launch {
            val update = data.copy(name = newName, age = newAge)
            db.upserData(update)
        }
    }

}