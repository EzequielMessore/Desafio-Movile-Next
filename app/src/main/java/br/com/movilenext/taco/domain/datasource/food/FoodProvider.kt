package br.com.movilenext.taco.domain.datasource.food

import br.com.movilenext.taco.data.ws.food.Food
import br.com.movilenext.taco.data.ws.food.FoodService
import dagger.Lazy
import io.reactivex.Observable
import javax.inject.Inject

class FoodProvider @Inject constructor(
    private val foodService: Lazy<FoodService>
) {
    fun getFoodByCategoryId(id: Int): Observable<List<Food>> =
        foodService.get().getFoodByCategoryId(id).map {
            println(it)
            it
        }

}