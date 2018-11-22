package br.com.movilenext.taco.data.ws.food

import br.com.movilenext.taco.domain.datasource.food.FoodDataSource
import javax.inject.Inject

class FoodService @Inject constructor(
    private val foodApi: FoodApi
) : FoodDataSource {

    override fun getFoodByCategoryId(id: Int)
            = foodApi.getFoodByCategory(id)

}