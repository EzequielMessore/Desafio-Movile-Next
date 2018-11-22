package br.com.movilenext.taco.data.ws.food

data class FoodAttributes(
    val carbohydrate: Attribute,
    val sodium: Attribute,
    val energy: Attribute,
    val cholesterol: Attribute,
    val iron: Attribute
)

data class Attribute(
    val qty: Double,
    val unit: String
)