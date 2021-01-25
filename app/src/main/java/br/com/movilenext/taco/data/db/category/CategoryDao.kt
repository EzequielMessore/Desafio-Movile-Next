package br.com.movilenext.taco.data.db.category

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
abstract class CategoryDao {
    @Query("SELECT * FROM category")
    abstract fun getAll(): Flowable<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg categories: CategoryEntity)

}