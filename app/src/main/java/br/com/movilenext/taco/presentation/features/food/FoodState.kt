package br.com.movilenext.taco.presentation.features.food

sealed class FoodState
data class FoodData(val data: List<FoodModel>) : FoodState()
object FoodLoading : FoodState()
data class FoodError(val error: Throwable) : FoodState()