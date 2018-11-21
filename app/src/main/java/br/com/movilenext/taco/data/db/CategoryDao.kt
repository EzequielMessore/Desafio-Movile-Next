package br.com.movilenext.taco.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getAll(): Flowable<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg categories: CategoryEntity)

}