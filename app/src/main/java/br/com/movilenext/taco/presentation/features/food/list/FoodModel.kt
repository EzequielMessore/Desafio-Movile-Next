package br.com.movilenext.taco.presentation.features.food.list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class FoodModel(
    val name: String,
    val baseInfo: String,
    val vitaminC: String,
    val categoryId: Int,
    val attributes: FoodAttributesModel
) : Parcelable

@Parcelize
class FoodAttributesModel(
        val carbohydrate: AttributeModel?,
        val sodium: AttributeModel?,
        val energy: AttributeModel?,
        val cholesterol: AttributeModel?,
        val iron: AttributeModel?
) : Parcelable

@Parcelize
data class AttributeModel(private val qty: String, private val unit: String) : Parcelable {
    val data: String
        get()  {
            return "%.2f".format(qty) + unit
        }
}