package br.com.movilenext.taco.domain.repository

import br.com.movilenext.taco.data.ws.Category
import io.reactivex.Single

interface CategoryRepository {
    fun categories(): Single<List<Category>>
}