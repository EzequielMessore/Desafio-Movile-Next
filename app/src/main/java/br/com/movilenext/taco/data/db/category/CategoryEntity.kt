package br.com.movilenext.taco.data.db.category

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)