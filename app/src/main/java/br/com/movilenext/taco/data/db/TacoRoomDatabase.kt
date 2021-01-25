package br.com.movilenext.taco.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.movilenext.taco.data.db.category.CategoryDao
import br.com.movilenext.taco.data.db.category.CategoryEntity
import br.com.movilenext.taco.data.db.converters.Converters
import br.com.movilenext.taco.data.db.food.FoodDao
import br.com.movilenext.taco.data.db.food.FoodEntity

@Database(
    entities = [
        CategoryEntity::class,
        FoodEntity::class
    ], version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TacoRoomDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun foodDao(): FoodDao
}