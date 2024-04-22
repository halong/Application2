package com.example.myapplication.database

import android.content.Context
import androidx.room.Room

class DatabaseUtil private constructor(context: Context) {
    //双重检测单例
    companion object {
        @Volatile
        private var databaseUtil: DatabaseUtil? = null
        fun getInstance(context: Context): DatabaseUtil {
            if (databaseUtil == null) {
                synchronized(DatabaseUtil::class) {
                    if (databaseUtil == null) {
                        databaseUtil = DatabaseUtil(context)
                    }
                }
            }
            return databaseUtil!!
        }
    }

    val myDatabase: MyDatabase
    init {
        myDatabase = Room.databaseBuilder(context, MyDatabase::class.java, "my_database")
            .allowMainThreadQueries().build()
    }


}