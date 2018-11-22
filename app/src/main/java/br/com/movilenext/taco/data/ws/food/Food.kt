package br.com.movilenext.taco.data.ws.food

import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("description")
    val name: String,

    @SerializedName("base_qty")
    val baseQtd: Int,

    @SerializedName("base_unit")
    val baseUnit: String,

    @SerializedName("vitaminC")
    val vitaminC: VitaminC,

    @SerializedName("category_id")
    val categoryId: VitaminC,

    val attributes: List<Attribute>

)

data class VitaminC(val qty: Double, val unit: String)