package br.com.movilenext.taco.data.db.food

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
abstract class FoodDao {
    @Query("SELECT * FROM food where category_id = :categoryId")
    abstract fun getFoodByCategoryId(categoryId: Int): Flowable<List<FoodEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg foods: FoodEntity)
}