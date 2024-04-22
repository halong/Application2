package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.entity.banner.Banner


@Database(entities = [Banner::class], version = 1,exportSchema = false)
abstract class MyDatabase:RoomDatabase() {
    abstract fun bannerDao():BannerDao
}