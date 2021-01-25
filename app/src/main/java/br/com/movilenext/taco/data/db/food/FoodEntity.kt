package br.com.movilenext.taco.data.db.food

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.movilenext.taco.data.ws.food.FoodAttributes
import br.com.movilenext.taco.data.ws.food.VitaminC

@Entity(tableName = "food")
data class FoodEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "base_qtd")
    val baseQtd: Int,
    @ColumnInfo(name = "base_unit")
    val baseUnit: String,
    val vitaminC: VitaminC?,
    @ColumnInfo(name = "category_id")
    val categoryId: Int,
    val attributes: FoodAttributes?
)

