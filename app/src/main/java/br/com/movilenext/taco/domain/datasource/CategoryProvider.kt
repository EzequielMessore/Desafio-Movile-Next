package br.com.movilenext.taco.domain.datasource

import br.com.movilenext.taco.presentation.features.category.CategoryModel
import io.reactivex.Observable

interface CategoryProvider {
    fun listCategory(): Observable<List<CategoryModel>>
}