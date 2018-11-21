package br.com.movilenext.taco.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class TacoRoomDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}