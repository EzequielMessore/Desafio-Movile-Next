package br.com.movilenext.taco.domain.datasource.food

import br.com.movilenext.taco.data.mappers.FoodModelMapper
import br.com.movilenext.taco.data.ws.food.FoodService
import br.com.movilenext.taco.presentation.features.food.list.FoodModel
import dagger.Lazy
import io.reactivex.Observable
import javax.inject.Inject

class FoodProvider @Inject constructor(
    private val foodService: Lazy<FoodService>,
    private val foodModelMapper: FoodModelMapper
) {
    fun getFoodByCategoryId(id: Int): Observable<List<FoodModel>> =
        foodService.get().getFoodByCategoryId(id).map {
            foodModelMapper.toFrom(it)
        }

}