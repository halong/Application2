package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.entity.banner.Banner

@Dao
interface BannerDao {
    @get:Query("SELECT * FROM banner")
    val getBanners: List<Banner>

    @Query("SELECT * FROM banner WHERE 'id' = :userId")
    fun getBannerById(userId: Int): Banner?

    @Query("SELECT * FROM banner WHERE 'id' IN (:userIds)")
    fun getBannersByIds(userIds: IntArray): List<Banner>

    @Insert(onConflict = OnConflictStrategy.REPLACE) //重复时则会替换。
    fun insert(vararg user: Banner)

    @Delete
    fun delete(vararg user: Banner)

    @Update
    fun update(vararg user: Banner)

    @Query("DELETE FROM banner")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM banner")
    fun countAll():Int
}